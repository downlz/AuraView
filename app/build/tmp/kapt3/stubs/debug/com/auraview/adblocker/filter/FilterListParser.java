package com.auraview.adblocker.filter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/auraview/adblocker/filter/FilterListParser;", "", "()V", "isComment", "", "line", "", "isLocalhost", "ip", "isValidDomain", "domain", "parseAdBlockOptions", "", "optionsString", "parseAdBlockRule", "Lcom/auraview/adblocker/filter/FilterRule;", "parseDomainListRule", "parseFilterList", "", "inputStream", "Ljava/io/InputStream;", "listType", "Lcom/auraview/adblocker/filter/FilterListParser$FilterListType;", "parseHostsRule", "parseLine", "Companion", "FilterListType", "app_debug"})
public final class FilterListParser {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FilterListParser";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] COMMENT_PREFIXES = {"!", "[", "#", ";"};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String OPTIONS_SEPARATOR = "$$";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex HOSTS_IP_PATTERN = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex HOSTS_LOCALHOST_PATTERN = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.filter.FilterListParser.Companion Companion = null;
    
    public FilterListParser() {
        super();
    }
    
    /**
     * Parse a filter list from an input stream
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.auraview.adblocker.filter.FilterRule> parseFilterList(@org.jetbrains.annotations.NotNull()
    java.io.InputStream inputStream, @org.jetbrains.annotations.NotNull()
    com.auraview.adblocker.filter.FilterListParser.FilterListType listType) {
        return null;
    }
    
    /**
     * Parse a single line into a FilterRule
     */
    private final com.auraview.adblocker.filter.FilterRule parseLine(java.lang.String line, com.auraview.adblocker.filter.FilterListParser.FilterListType listType) {
        return null;
    }
    
    /**
     * Check if a line is a comment
     */
    private final boolean isComment(java.lang.String line) {
        return false;
    }
    
    /**
     * Parse AdBlock Plus style rule
     */
    private final com.auraview.adblocker.filter.FilterRule parseAdBlockRule(java.lang.String line) {
        return null;
    }
    
    /**
     * Parse AdBlock options string
     */
    private final java.util.Map<java.lang.String, java.lang.String> parseAdBlockOptions(java.lang.String optionsString) {
        return null;
    }
    
    /**
     * Parse hosts file rule
     */
    private final com.auraview.adblocker.filter.FilterRule parseHostsRule(java.lang.String line) {
        return null;
    }
    
    /**
     * Parse simple domain list rule
     */
    private final com.auraview.adblocker.filter.FilterRule parseDomainListRule(java.lang.String line) {
        return null;
    }
    
    /**
     * Check if IP is localhost
     */
    private final boolean isLocalhost(java.lang.String ip) {
        return false;
    }
    
    /**
     * Basic domain validation
     */
    private final boolean isValidDomain(java.lang.String domain) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/auraview/adblocker/filter/FilterListParser$Companion;", "", "()V", "COMMENT_PREFIXES", "", "", "[Ljava/lang/String;", "HOSTS_IP_PATTERN", "Lkotlin/text/Regex;", "HOSTS_LOCALHOST_PATTERN", "OPTIONS_SEPARATOR", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * Filter list types
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/auraview/adblocker/filter/FilterListParser$FilterListType;", "", "(Ljava/lang/String;I)V", "ADBLOCK", "HOSTS", "DOMAIN_LIST", "app_debug"})
    public static enum FilterListType {
        /*public static final*/ ADBLOCK /* = new ADBLOCK() */,
        /*public static final*/ HOSTS /* = new HOSTS() */,
        /*public static final*/ DOMAIN_LIST /* = new DOMAIN_LIST() */;
        
        FilterListType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.auraview.adblocker.filter.FilterListParser.FilterListType> getEntries() {
            return null;
        }
    }
}