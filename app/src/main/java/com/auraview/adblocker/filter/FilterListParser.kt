package com.auraview.adblocker.filter

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class FilterListParser {

    companion object {
        private const val TAG = "FilterListParser"

        // Common comment prefixes
        private val COMMENT_PREFIXES = arrayOf("!", "[", "#", ";")

        // AdBlock Plus filter options separator
        private const val OPTIONS_SEPARATOR = "$$"

        // Hosts file patterns
        private val HOSTS_IP_PATTERN = Regex("^\\s*(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+(.+)$")
        private val HOSTS_LOCALHOST_PATTERN = Regex("^(?:127\\.0\\.0\\.1|0\\.0\\.0\\.0|::1|::)\\s+(.+)$")
    }

    /**
     * Parse a filter list from an input stream
     */
    fun parseFilterList(inputStream: InputStream, listType: FilterListType = FilterListType.ADBLOCK): List<FilterRule> {
        val rules = mutableListOf<FilterRule>()

        try {
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                var lineNumber = 0
                reader.forEachLine { line ->
                    lineNumber++
                    val rule = parseLine(line.trim(), listType)
                    if (rule != null) {
                        rules.add(rule)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing filter list", e)
        }

        Log.d(TAG, "Parsed ${rules.size} rules from filter list")
        return rules
    }

    /**
     * Parse a single line into a FilterRule
     */
    private fun parseLine(line: String, listType: FilterListType): FilterRule? {
        // Skip empty lines and comments
        if (line.isEmpty() || isComment(line)) {
            return null
        }

        return when (listType) {
            FilterListType.ADBLOCK -> parseAdBlockRule(line)
            FilterListType.HOSTS -> parseHostsRule(line)
            FilterListType.DOMAIN_LIST -> parseDomainListRule(line)
        }
    }

    /**
     * Check if a line is a comment
     */
    private fun isComment(line: String): Boolean {
        return COMMENT_PREFIXES.any { line.startsWith(it) }
    }

    /**
     * Parse AdBlock Plus style rule
     */
    private fun parseAdBlockRule(line: String): FilterRule? {
        try {
            // Handle exception rules (starting with @@)
            val isException = line.startsWith("@@")
            val ruleText = if (isException) line.substring(2) else line

            // Split rule from options
            val parts = ruleText.split(OPTIONS_SEPARATOR, limit = 2)
            val pattern = parts[0]
            val optionsString = if (parts.size > 1) parts[1] else ""

            // Parse options
            val options = parseAdBlockOptions(optionsString)

            // Skip element hiding rules (they contain #)
            if (pattern.contains("#")) {
                return null
            }

            // Skip rules that are too short or generic
            if (pattern.length < 3) {
                return null
            }

            return FilterRule(
                pattern = pattern,
                isException = isException,
                options = options
            )

        } catch (e: Exception) {
            Log.w(TAG, "Failed to parse AdBlock rule: $line", e)
            return null
        }
    }

    /**
     * Parse AdBlock options string
     */
    private fun parseAdBlockOptions(optionsString: String): Map<String, String> {
        if (optionsString.isEmpty()) return emptyMap()

        val options = mutableMapOf<String, String>()

        optionsString.split(",").forEach { option ->
            val trimmed = option.trim()
            if (trimmed.isNotEmpty()) {
                // Handle key=value options
                if (trimmed.contains("=")) {
                    val (key, value) = trimmed.split("=", limit = 2)
                    options[key.trim()] = value.trim()
                } else {
                    // Handle flag options
                    options[trimmed] = "true"
                }
            }
        }

        return options
    }

    /**
     * Parse hosts file rule
     */
    private fun parseHostsRule(line: String): FilterRule? {
        try {
            // Match IP address followed by hostname
            val match = HOSTS_IP_PATTERN.find(line) ?: return null

            val ip = match.groupValues[1]
            val hostname = match.groupValues[2].trim()

            // Skip localhost entries
            if (isLocalhost(ip)) return null

            // Skip invalid hostnames
            if (hostname.isEmpty() || hostname.contains(" ") || hostname.startsWith("#")) {
                return null
            }

            return FilterRule(
                pattern = hostname,
                isDomainOnly = true
            )

        } catch (e: Exception) {
            Log.w(TAG, "Failed to parse hosts rule: $line", e)
            return null
        }
    }

    /**
     * Parse simple domain list rule
     */
    private fun parseDomainListRule(line: String): FilterRule? {
        try {
            val domain = line.trim()

            // Skip empty lines, comments, and invalid domains
            if (domain.isEmpty() || domain.startsWith("#") || domain.contains(" ")) {
                return null
            }

            // Basic domain validation
            if (!isValidDomain(domain)) {
                return null
            }

            return FilterRule(
                pattern = domain,
                isDomainOnly = true
            )

        } catch (e: Exception) {
            Log.w(TAG, "Failed to parse domain list rule: $line", e)
            return null
        }
    }

    /**
     * Check if IP is localhost
     */
    private fun isLocalhost(ip: String): Boolean {
        return ip == "127.0.0.1" || ip == "0.0.0.0" || ip == "::1" || ip == "::"
    }

    /**
     * Basic domain validation
     */
    private fun isValidDomain(domain: String): Boolean {
        // Basic checks - can be enhanced
        return domain.length >= 3 &&
               domain.contains(".") &&
               !domain.startsWith(".") &&
               !domain.endsWith(".") &&
               domain.matches(Regex("^[a-zA-Z0-9.-]+$"))
    }

    /**
     * Filter list types
     */
    enum class FilterListType {
        ADBLOCK,    // AdBlock Plus syntax
        HOSTS,      // Hosts file format
        DOMAIN_LIST // Simple domain list
    }
}
