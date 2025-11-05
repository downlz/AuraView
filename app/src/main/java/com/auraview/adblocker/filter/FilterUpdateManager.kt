package com.auraview.adblocker.filter

import android.content.Context
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.TimeUnit

class FilterUpdateManager(private val context: Context) {

    companion object {
        private const val TAG = "FilterUpdateManager"
        private const val UPDATE_WORK_NAME = "filter_update_work"
        private const val CACHE_DIR = "filter_cache"
        private const val METADATA_FILE = "filter_metadata.json"

        // uBlockOrigin filter list URLs
        private const val UBLOCK_BASE_URL = "https://raw.githubusercontent.com/uBlockOrigin/uAssets/master/filters/"
        val DEFAULT_FILTER_LISTS = mapOf(
            "ublock-filters" to "${UBLOCK_BASE_URL}filters.txt",
            "ublock-privacy" to "${UBLOCK_BASE_URL}privacy.txt",
            "ublock-malware" to "${UBLOCK_BASE_URL}badware.txt",
            "ublock-annoyances" to "${UBLOCK_BASE_URL}annoyances.txt",
            "ublock-mobile" to "${UBLOCK_BASE_URL}filters-mobile.txt"
        )
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private val cacheDir = File(context.cacheDir, CACHE_DIR).apply { mkdirs() }
    private val metadataFile = File(cacheDir, METADATA_FILE)

    // Update listeners
    private val updateListeners = mutableListOf<(String, Boolean, String?) -> Unit>()

    init {
        // Ensure cache directory exists
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
    }

    /**
     * Add an update listener
     */
    fun addUpdateListener(listener: (filterName: String, success: Boolean, error: String?) -> Unit) {
        updateListeners.add(listener)
    }

    /**
     * Remove an update listener
     */
    fun removeUpdateListener(listener: (String, Boolean, String?) -> Unit) {
        updateListeners.remove(listener)
    }

    /**
     * Update a specific filter list
     */
    suspend fun updateFilterList(filterName: String, url: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Updating filter list: $filterName from $url")

                notifyUpdateStarted(filterName)

                val response = downloadFilterList(url)
                if (response == null) {
                    val error = "Failed to download filter list"
                    Log.e(TAG, error)
                    notifyUpdateFailed(filterName, error)
                    return@withContext false
                }

                val rules = parseFilterList(response, filterName)
                if (rules.isEmpty()) {
                    val error = "No valid rules found in filter list"
                    Log.w(TAG, error)
                    notifyUpdateFailed(filterName, error)
                    return@withContext false
                }

                // Save to cache
                saveFilterToCache(filterName, rules)

                // Update metadata
                updateMetadata(filterName, System.currentTimeMillis(), rules.size)

                // Add to filter engine
                val filterEngine = FilterEngine.getInstance(context)
                filterEngine.addRules(rules)

                Log.d(TAG, "Successfully updated filter list: $filterName (${rules.size} rules)")
                notifyUpdateSuccess(filterName)

                true
            } catch (e: Exception) {
                val error = "Error updating filter list: ${e.message}"
                Log.e(TAG, error, e)
                notifyUpdateFailed(filterName, error)
                false
            }
        }
    }

    /**
     * Update all default filter lists
     */
    suspend fun updateAllFilters(): Map<String, Boolean> {
        val results = mutableMapOf<String, Boolean>()

        DEFAULT_FILTER_LISTS.forEach { (name, url) ->
            val success = updateFilterList(name, url)
            results[name] = success

            // Small delay between updates to be respectful to the server
            delay(1000)
        }

        return results
    }

    /**
     * Load cached filter lists into the filter engine
     */
    suspend fun loadCachedFilters(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val metadata = loadMetadata()
                val allRules = mutableListOf<FilterRule>()

                metadata.forEach { (filterName, filterMetadata) ->
                    val cachedRules = loadFilterFromCache(filterName)
                    if (cachedRules != null) {
                        allRules.addAll(cachedRules)
                        Log.d(TAG, "Loaded ${cachedRules.size} cached rules for $filterName")
                    }
                }

                if (allRules.isNotEmpty()) {
                    val filterEngine = FilterEngine.getInstance(context)
                    filterEngine.addRules(allRules)
                    Log.d(TAG, "Loaded ${allRules.size} total cached rules")
                    return@withContext true
                }

                false
            } catch (e: Exception) {
                Log.e(TAG, "Error loading cached filters", e)
                false
            }
        }
    }

    /**
     * Schedule periodic filter updates
     */
    fun schedulePeriodicUpdates(intervalHours: Int = 24) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        val updateWork = PeriodicWorkRequestBuilder<FilterUpdateWorker>(intervalHours.toLong(), TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            UPDATE_WORK_NAME,
            ExistingPeriodicWorkPolicy.UPDATE,
            updateWork
        )

        Log.d(TAG, "Scheduled periodic filter updates every $intervalHours hours")
    }

    /**
     * Cancel periodic updates
     */
    fun cancelPeriodicUpdates() {
        WorkManager.getInstance(context).cancelUniqueWork(UPDATE_WORK_NAME)
        Log.d(TAG, "Cancelled periodic filter updates")
    }

    /**
     * Get filter metadata
     */
    fun getFilterMetadata(): Map<String, FilterMetadata> {
        return loadMetadata()
    }

    /**
     * Clear all cached filters
     */
    fun clearCache() {
        try {
            cacheDir.listFiles()?.forEach { it.delete() }
            Log.d(TAG, "Filter cache cleared")
        } catch (e: Exception) {
            Log.e(TAG, "Error clearing filter cache", e)
        }
    }

    // Private helper methods

    private fun downloadFilterList(url: String): String? {
        return try {
            val request = Request.Builder()
                .url(url)
                .header("User-Agent", "AuraView/1.0")
                .build()

            val response = httpClient.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.e(TAG, "HTTP error: ${response.code}")
                return null
            }

            response.body?.string()
        } catch (e: IOException) {
            Log.e(TAG, "Network error downloading filter list", e)
            null
        }
    }

    private fun parseFilterList(content: String, filterName: String): List<FilterRule> {
        return try {
            val parser = FilterListParser()
            val inputStream = content.byteInputStream()

            val listType = when {
                filterName.contains("hosts") -> FilterListParser.FilterListType.HOSTS
                else -> FilterListParser.FilterListType.ADBLOCK
            }

            parser.parseFilterList(inputStream, listType)
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing filter list content", e)
            emptyList()
        }
    }

    private fun saveFilterToCache(filterName: String, rules: List<FilterRule>) {
        try {
            val cacheFile = File(cacheDir, "$filterName.txt")
            FileOutputStream(cacheFile).use { fos ->
                rules.forEach { rule ->
                    fos.write("${rule.pattern}\n".toByteArray())
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error saving filter to cache", e)
        }
    }

    private fun loadFilterFromCache(filterName: String): List<FilterRule>? {
        return try {
            val cacheFile = File(cacheDir, "$filterName.txt")
            if (!cacheFile.exists()) return null

            val content = cacheFile.readText()
            parseFilterList(content, filterName)
        } catch (e: Exception) {
            Log.e(TAG, "Error loading filter from cache", e)
            null
        }
    }

    private fun updateMetadata(filterName: String, lastUpdate: Long, ruleCount: Int) {
        try {
            val metadata = loadMetadata().toMutableMap()
            metadata[filterName] = FilterMetadata(lastUpdate, ruleCount)

            val json = JSONObject()
            metadata.forEach { (name, meta) ->
                json.put(name, JSONObject().apply {
                    put("lastUpdate", meta.lastUpdate)
                    put("ruleCount", meta.ruleCount)
                })
            }

            metadataFile.writeText(json.toString())
        } catch (e: Exception) {
            Log.e(TAG, "Error updating metadata", e)
        }
    }

    private fun loadMetadata(): Map<String, FilterMetadata> {
        return try {
            if (!metadataFile.exists()) return emptyMap()

            val json = JSONObject(metadataFile.readText())
            val metadata = mutableMapOf<String, FilterMetadata>()

            json.keys().forEach { key ->
                val filterJson = json.getJSONObject(key)
                metadata[key] = FilterMetadata(
                    filterJson.getLong("lastUpdate"),
                    filterJson.getInt("ruleCount")
                )
            }

            metadata
        } catch (e: Exception) {
            Log.e(TAG, "Error loading metadata", e)
            emptyMap()
        }
    }

    private fun notifyUpdateStarted(filterName: String) {
        updateListeners.forEach { it(filterName, false, null) }
    }

    private fun notifyUpdateSuccess(filterName: String) {
        updateListeners.forEach { it(filterName, true, null) }
    }

    private fun notifyUpdateFailed(filterName: String, error: String) {
        updateListeners.forEach { it(filterName, false, error) }
    }

    // Data classes
    data class FilterMetadata(
        val lastUpdate: Long,
        val ruleCount: Int
    )
}
