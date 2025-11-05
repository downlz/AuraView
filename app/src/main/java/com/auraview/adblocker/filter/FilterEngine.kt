package com.auraview.adblocker.filter

import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet

class FilterEngine private constructor(context: Context) {

    companion object {
        private const val TAG = "FilterEngine"
        private var instance: FilterEngine? = null
        private val instanceMutex = Mutex()

        @Synchronized
        fun getInstance(context: Context): FilterEngine {
            return instance ?: FilterEngine(context.applicationContext).also { instance = it }
        }
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private val engineMutex = Mutex()

    // Thread-safe collections for filter rules
    private val domainRules = ConcurrentHashMap<String, MutableList<FilterRule>>()
    private val wildcardRules = ConcurrentSkipListSet<FilterRule>()
    private val regexRules = mutableListOf<FilterRule>()
    private val exceptionRules = mutableListOf<FilterRule>()

    // Bloom filter for fast negative lookups (optional optimization)
    private var bloomFilter: SimpleBloomFilter? = null

    // Statistics
    private var totalRules = 0
    private var lastUpdateTime = 0L

    init {
        Log.d(TAG, "FilterEngine initialized")
    }

    /**
     * Add filter rules to the engine
     */
    suspend fun addRules(rules: List<FilterRule>) = engineMutex.withLock {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "Adding ${rules.size} rules to filter engine")

            rules.forEach { rule ->
                when {
                    rule.isException -> {
                        exceptionRules.add(rule)
                    }
                    rule.pattern.contains("*") || rule.pattern.contains("?") -> {
                        wildcardRules.add(rule)
                    }
                    rule.pattern.startsWith("/") && rule.pattern.endsWith("/") -> {
                        // Regex pattern
                        regexRules.add(FilterRule(
                            pattern = rule.pattern.substring(1, rule.pattern.length - 1),
                            isRegex = true,
                            isException = rule.isException,
                            options = rule.options
                        ))
                    }
                    rule.isDomainOnly -> {
                        // Domain-only rules
                        val domain = rule.pattern.lowercase()
                        synchronized(domainRules) {
                            val rulesList = domainRules.getOrPut(domain) { mutableListOf() }
                            rulesList.add(rule)
                        }
                    }
                    else -> {
                        // General pattern rules
                        wildcardRules.add(rule)
                    }
                }
            }

            totalRules += rules.size
            lastUpdateTime = System.currentTimeMillis()

            // Rebuild bloom filter if we have too many rules
            if (totalRules > 10000) {
                rebuildBloomFilter()
            }

            Log.d(TAG, "Filter engine updated: $totalRules total rules")
        }
    }

    /**
     * Remove all filter rules
     */
    suspend fun clearRules() = engineMutex.withLock {
        domainRules.clear()
        wildcardRules.clear()
        regexRules.clear()
        exceptionRules.clear()
        bloomFilter = null
        totalRules = 0
        lastUpdateTime = 0L

        Log.d(TAG, "All filter rules cleared")
    }

    /**
     * Check if a domain should be blocked
     */
    suspend fun shouldBlock(domain: String, requestType: String = "other"): Boolean = engineMutex.withLock {
        val normalizedDomain = domain.lowercase().trim()

        // Quick bloom filter check (if available)
        if (bloomFilter?.mightContain(normalizedDomain) == false) {
            return false
        }

        // Check exception rules first (whitelist)
        if (matchesAnyRule(normalizedDomain, exceptionRules, requestType)) {
            return false
        }

        // Check domain-specific rules
        val domainRulesList = domainRules[normalizedDomain]
        if (domainRulesList != null && matchesAnyRule(normalizedDomain, domainRulesList, requestType)) {
            return true
        }

        // Check wildcard and pattern rules
        if (matchesAnyRule(normalizedDomain, wildcardRules, requestType)) {
            return true
        }

        // Check regex rules (most expensive, do last)
        if (matchesRegexRules(normalizedDomain, requestType)) {
            return true
        }

        return false
    }

    /**
     * Check if domain matches any rule in the list
     */
    private fun matchesAnyRule(domain: String, rules: Collection<FilterRule>, requestType: String): Boolean {
        return rules.any { rule ->
            rule.matchesDomain(domain) && rule.shouldBlock(requestType)
        }
    }

    /**
     * Check regex rules (expensive operation)
     */
    private fun matchesRegexRules(domain: String, requestType: String): Boolean {
        return regexRules.any { rule ->
            try {
                Regex(rule.pattern).matches(domain) && rule.shouldBlock(requestType)
            } catch (e: Exception) {
                Log.w(TAG, "Invalid regex pattern: ${rule.pattern}", e)
                false
            }
        }
    }

    /**
     * Get statistics about the filter engine
     */
    fun getStats(): FilterStats {
        return FilterStats(
            totalRules = totalRules,
            domainRules = domainRules.size,
            wildcardRules = wildcardRules.size,
            regexRules = regexRules.size,
            exceptionRules = exceptionRules.size,
            lastUpdateTime = lastUpdateTime,
            bloomFilterSize = bloomFilter?.size ?: 0
        )
    }

    /**
     * Rebuild bloom filter for performance optimization
     */
    private fun rebuildBloomFilter() {
        val allDomains = domainRules.keys + wildcardRules.mapNotNull { extractDomainFromPattern(it.pattern) }
        bloomFilter = SimpleBloomFilter(allDomains.size * 2, 0.01) // 1% false positive rate

        allDomains.forEach { domain ->
            bloomFilter?.add(domain)
        }

        Log.d(TAG, "Bloom filter rebuilt with ${bloomFilter?.size ?: 0} entries")
    }

    /**
     * Extract domain from a pattern (best effort)
     */
    private fun extractDomainFromPattern(pattern: String): String? {
        return when {
            pattern.startsWith("||") -> {
                val domainPart = pattern.substring(2).substringBefore("^").substringBefore("$")
                domainPart.takeIf { it.contains(".") }
            }
            pattern.contains(".") && !pattern.contains("*") -> {
                pattern.substringBefore("$").substringBefore("^")
            }
            else -> null
        }
    }

    /**
     * Simple Bloom Filter implementation for fast lookups
     */
    private class SimpleBloomFilter(private val expectedInsertions: Int, private val falsePositiveRate: Double) {

        private val numBits: Int
        private val numHashFunctions: Int
        private val bitArray: BooleanArray

        val size: Int get() = expectedInsertions

        init {
            val optimalBits = (-expectedInsertions * kotlin.math.ln(falsePositiveRate) / (kotlin.math.ln(2.0) * kotlin.math.ln(2.0))).toInt()
            numBits = maxOf(optimalBits, 1024) // Minimum 1024 bits

            val optimalHashes = (numBits.toDouble() / expectedInsertions * kotlin.math.ln(2.0)).toInt()
            numHashFunctions = maxOf(optimalHashes, 1)

            bitArray = BooleanArray(numBits)
        }

        fun add(item: String) {
            val hashes = getHashes(item)
            hashes.forEach { hash ->
                bitArray[hash % numBits] = true
            }
        }

        fun mightContain(item: String): Boolean {
            val hashes = getHashes(item)
            return hashes.all { hash ->
                bitArray[hash % numBits]
            }
        }

        private fun getHashes(item: String): List<Int> {
            val hashes = mutableListOf<Int>()
            var hash1 = item.hashCode()
            var hash2 = hash1

            for (i in 0 until numHashFunctions) {
                hashes.add(Math.abs(hash1))
                hash1 += hash2
            }

            return hashes
        }
    }

    /**
     * Filter statistics data class
     */
    data class FilterStats(
        val totalRules: Int,
        val domainRules: Int,
        val wildcardRules: Int,
        val regexRules: Int,
        val exceptionRules: Int,
        val lastUpdateTime: Long,
        val bloomFilterSize: Int
    )
}
