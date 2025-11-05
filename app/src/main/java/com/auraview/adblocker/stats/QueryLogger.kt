package com.auraview.adblocker.stats

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

class QueryLogger private constructor(context: Context) {

    companion object {
        private const val TAG = "QueryLogger"
        private const val PREFS_NAME = "auraview_query_stats"
        private const val LOG_FILE_NAME = "query_log.json"
        private const val MAX_LOG_ENTRIES = 10000 // Limit log size

        private var instance: QueryLogger? = null
        private val instanceMutex = Mutex()

        @Synchronized
        fun getInstance(context: Context): QueryLogger {
            return instance ?: QueryLogger(context.applicationContext).also { instance = it }
        }
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val logFile = File(context.filesDir, LOG_FILE_NAME)
    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val logMutex = Mutex()

    // Statistics counters
    private val totalQueries = AtomicInteger(0)
    private val blockedQueries = AtomicInteger(0)
    private val estimatedDataSaved = AtomicLong(0)

    // Domain tracking (for top domains)
    private val domainStats = ConcurrentHashMap<String, DomainStat>()

    // Time tracking
    private val startTime = System.currentTimeMillis()

    init {
        Log.d(TAG, "QueryLogger initialized")
        loadPersistedStats()
    }

    /**
     * Log a DNS query
     */
    suspend fun logQuery(domain: String, wasBlocked: Boolean) = logMutex.withLock {
        withContext(Dispatchers.IO) {
            try {
                totalQueries.incrementAndGet()

                if (wasBlocked) {
                    blockedQueries.incrementAndGet()
                    // Estimate data saved (rough calculation: 1KB per blocked request)
                    estimatedDataSaved.addAndGet(1024)
                }

                // Update domain statistics
                updateDomainStats(domain, wasBlocked)

                // Persist statistics periodically
                val queryCount = totalQueries.get()
                if ((queryCount % 100) == 0) {
                    persistStats()
                } else {
                    Unit
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error logging query", e)
            }
        }
    }

    /**
     * Get current statistics
     */
    fun getStatistics(): QueryStatistics {
        return QueryStatistics(
            totalQueries = totalQueries.get(),
            blockedQueries = blockedQueries.get(),
            allowedQueries = totalQueries.get() - blockedQueries.get(),
            estimatedDataSaved = estimatedDataSaved.get(),
            timeRange = System.currentTimeMillis() - startTime,
            topBlockedDomains = getTopBlockedDomains(10),
            topAllowedDomains = getTopAllowedDomains(10)
        )
    }

    /**
     * Reset all statistics
     */
    suspend fun resetStatistics() = logMutex.withLock {
        withContext(Dispatchers.IO) {
            totalQueries.set(0)
            blockedQueries.set(0)
            estimatedDataSaved.set(0)
            domainStats.clear()

            // Clear persisted data
            prefs.edit().clear().apply()
            if (logFile.exists()) {
                logFile.delete()
            }

            Log.d(TAG, "Statistics reset")
        }
    }

    /**
     * Get top blocked domains
     */
    private fun getTopBlockedDomains(limit: Int): List<DomainCount> {
        val filtered = domainStats.values.filter { it.blockedCount > 0 }
        val sorted = filtered.sortedByDescending { it.blockedCount }
        val limited = sorted.take(limit)
        return limited.map { DomainCount(it.domain, it.blockedCount) }
    }

    /**
     * Get top allowed domains
     */
    private fun getTopAllowedDomains(limit: Int): List<DomainCount> {
        val filtered = domainStats.values.filter { it.allowedCount > 0 }
        val sorted = filtered.sortedByDescending { it.allowedCount }
        val limited = sorted.take(limit)
        return limited.map { DomainCount(it.domain, it.allowedCount) }
    }

    /**
     * Update domain statistics
     */
    private fun updateDomainStats(domain: String, wasBlocked: Boolean) {
        val normalizedDomain = domain.lowercase().trim()
        val stat = domainStats.computeIfAbsent(normalizedDomain) { DomainStat(it) }

        if (wasBlocked) {
            stat.blockedCount++
        } else {
            stat.allowedCount++
        }
    }

    /**
     * Persist statistics to storage
     */
    private fun persistStats() {
        try {
            val json = JSONObject().apply {
                put("totalQueries", totalQueries.get())
                put("blockedQueries", blockedQueries.get())
                put("estimatedDataSaved", estimatedDataSaved.get())
                put("lastUpdate", System.currentTimeMillis())

                // Save domain stats (limit to prevent huge files)
                val domainArray = JSONArray()
                domainStats.values
                    .sortedByDescending { it.blockedCount + it.allowedCount }
                    .take(1000) // Limit saved domains
                    .forEach { stat ->
                        domainArray.put(JSONObject().apply {
                            put("domain", stat.domain)
                            put("blocked", stat.blockedCount)
                            put("allowed", stat.allowedCount)
                        })
                    }
                put("domains", domainArray)
            }

            logFile.writeText(json.toString())

        } catch (e: Exception) {
            Log.e(TAG, "Error persisting statistics", e)
        }
    }

    /**
     * Load persisted statistics
     */
    private fun loadPersistedStats() {
        try {
            if (!logFile.exists()) return

            val json = JSONObject(logFile.readText())

            totalQueries.set(json.optInt("totalQueries", 0))
            blockedQueries.set(json.optInt("blockedQueries", 0))
            estimatedDataSaved.set(json.optLong("estimatedDataSaved", 0))

            // Load domain stats
            val domainArray = json.optJSONArray("domains")
            if (domainArray != null) {
                for (i in 0 until domainArray.length()) {
                    val domainJson = domainArray.getJSONObject(i)
                    val domain = domainJson.getString("domain")
                    val blocked = domainJson.getInt("blocked")
                    val allowed = domainJson.getInt("allowed")

                    domainStats[domain] = DomainStat(domain, blocked, allowed)
                }
            }

            Log.d(TAG, "Loaded persisted statistics: ${totalQueries.get()} queries")

        } catch (e: Exception) {
            Log.e(TAG, "Error loading persisted statistics", e)
        }
    }

    // Data classes
    data class QueryStatistics(
        val totalQueries: Int,
        val blockedQueries: Int,
        val allowedQueries: Int,
        val estimatedDataSaved: Long,
        val timeRange: Long,
        val topBlockedDomains: List<DomainCount>,
        val topAllowedDomains: List<DomainCount>
    )

    data class DomainCount(
        val domain: String,
        val count: Int
    )

    private data class DomainStat(
        val domain: String,
        var blockedCount: Int = 0,
        var allowedCount: Int = 0
    )
}
