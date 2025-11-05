package com.auraview.adblocker.filter

data class FilterRule(
    val pattern: String,
    val isRegex: Boolean = false,
    val isDomainOnly: Boolean = false,
    val isException: Boolean = false,
    val options: Map<String, String> = emptyMap()
) {
    companion object {
        // Common option keys
        const val OPTION_DOMAIN = "domain"
        const val OPTION_THIRD_PARTY = "third-party"
        const val OPTION_FIRST_PARTY = "first-party"
        const val OPTION_SCRIPT = "script"
        const val OPTION_IMAGE = "image"
        const val OPTION_STYLESHEET = "stylesheet"
        const val OPTION_OBJECT = "object"
        const val OPTION_XMLHTTPREQUEST = "xmlhttprequest"
        const val OPTION_OBJECT_SUBREQUEST = "object-subrequest"
        const val OPTION_SUBDOCUMENT = "subdocument"
        const val OPTION_DOCUMENT = "document"
        const val OPTION_ELEMHIDE = "elemhide"
        const val OPTION_GENERICHIDE = "generichide"
        const val OPTION_GENERICBLOCK = "genericblock"
        const val OPTION_POPUP = "popup"
        const val OPTION_OTHER = "other"
    }

    fun matchesDomain(domain: String): Boolean {
        return when {
            isRegex -> {
                try {
                    Regex(pattern).matches(domain)
                } catch (e: Exception) {
                    false
                }
            }
            pattern.startsWith("||") && pattern.endsWith("^") -> {
                // Domain anchor pattern: ||domain.com^
                val domainPattern = pattern.substring(2, pattern.length - 1)
                domain == domainPattern || domain.endsWith(".$domainPattern")
            }
            pattern.startsWith("||") -> {
                // Domain anchor pattern: ||domain.com
                val domainPattern = pattern.substring(2)
                domain == domainPattern || domain.endsWith(".$domainPattern")
            }
            pattern.startsWith("|") && pattern.endsWith("|") -> {
                // Exact match: |http://domain.com|
                val exactPattern = pattern.substring(1, pattern.length - 1)
                domain == exactPattern
            }
            pattern.endsWith("^") -> {
                // Separator pattern: domain.com^
                val basePattern = pattern.substring(0, pattern.length - 1)
                domain == basePattern || domain.startsWith("$basePattern.")
            }
            else -> {
                // Contains pattern
                domain.contains(pattern)
            }
        }
    }

    fun shouldBlock(requestType: String = "other"): Boolean {
        if (isException) return false

        // Check if rule has type restrictions
        val typeOption = options[OPTION_SCRIPT] ?: options[OPTION_IMAGE] ?: options[OPTION_STYLESHEET] ?:
                        options[OPTION_OBJECT] ?: options[OPTION_XMLHTTPREQUEST] ?: options[OPTION_OBJECT_SUBREQUEST] ?:
                        options[OPTION_SUBDOCUMENT] ?: options[OPTION_DOCUMENT] ?: options[OPTION_POPUP] ?:
                        options[OPTION_OTHER]

        return if (typeOption != null) {
            // Rule has type restrictions, check if request type matches
            when (requestType.lowercase()) {
                "script" -> options.containsKey(OPTION_SCRIPT)
                "image" -> options.containsKey(OPTION_IMAGE)
                "stylesheet" -> options.containsKey(OPTION_STYLESHEET)
                "object" -> options.containsKey(OPTION_OBJECT)
                "xmlhttprequest" -> options.containsKey(OPTION_XMLHTTPREQUEST)
                "object-subrequest" -> options.containsKey(OPTION_OBJECT_SUBREQUEST)
                "subdocument" -> options.containsKey(OPTION_SUBDOCUMENT)
                "document" -> options.containsKey(OPTION_DOCUMENT)
                "popup" -> options.containsKey(OPTION_POPUP)
                else -> options.containsKey(OPTION_OTHER)
            }
        } else {
            // No type restrictions, block by default
            true
        }
    }

    override fun toString(): String {
        val prefix = if (isException) "@@" else ""
        val suffix = if (options.isNotEmpty()) {
            "$${options.entries.joinToString(",") { "${it.key}=${it.value}" }}"
        } else ""
        return "$prefix$pattern$suffix"
    }
}
