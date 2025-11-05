package com.auraview.adblocker.filter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0006\u0010 \u001a\u00020!J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0%2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0018\u0010\'\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020)H\u0002J \u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010+R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/auraview/adblocker/filter/FilterEngine;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bloomFilter", "Lcom/auraview/adblocker/filter/FilterEngine$SimpleBloomFilter;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "domainRules", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/auraview/adblocker/filter/FilterRule;", "engineMutex", "Lkotlinx/coroutines/sync/Mutex;", "exceptionRules", "lastUpdateTime", "", "regexRules", "totalRules", "", "wildcardRules", "Ljava/util/concurrent/ConcurrentSkipListSet;", "addRules", "rules", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearRules", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractDomainFromPattern", "pattern", "getStats", "Lcom/auraview/adblocker/filter/FilterEngine$FilterStats;", "matchesAnyRule", "", "domain", "", "requestType", "matchesRegexRules", "rebuildBloomFilter", "", "shouldBlock", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "FilterStats", "SimpleBloomFilter", "app_debug"})
public final class FilterEngine {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FilterEngine";
    @org.jetbrains.annotations.Nullable()
    private static com.auraview.adblocker.filter.FilterEngine instance;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.sync.Mutex instanceMutex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex engineMutex = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.auraview.adblocker.filter.FilterRule>> domainRules = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentSkipListSet<com.auraview.adblocker.filter.FilterRule> wildcardRules = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.auraview.adblocker.filter.FilterRule> regexRules = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.auraview.adblocker.filter.FilterRule> exceptionRules = null;
    @org.jetbrains.annotations.Nullable()
    private com.auraview.adblocker.filter.FilterEngine.SimpleBloomFilter bloomFilter;
    private int totalRules = 0;
    private long lastUpdateTime = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.filter.FilterEngine.Companion Companion = null;
    
    private FilterEngine(android.content.Context context) {
        super();
    }
    
    /**
     * Add filter rules to the engine
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addRules(@org.jetbrains.annotations.NotNull()
    java.util.List<com.auraview.adblocker.filter.FilterRule> rules, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Remove all filter rules
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearRules(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Check if a domain should be blocked
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object shouldBlock(@org.jetbrains.annotations.NotNull()
    java.lang.String domain, @org.jetbrains.annotations.NotNull()
    java.lang.String requestType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Check if domain matches any rule in the list
     */
    private final boolean matchesAnyRule(java.lang.String domain, java.util.Collection<com.auraview.adblocker.filter.FilterRule> rules, java.lang.String requestType) {
        return false;
    }
    
    /**
     * Check regex rules (expensive operation)
     */
    private final boolean matchesRegexRules(java.lang.String domain, java.lang.String requestType) {
        return false;
    }
    
    /**
     * Get statistics about the filter engine
     */
    @org.jetbrains.annotations.NotNull()
    public final com.auraview.adblocker.filter.FilterEngine.FilterStats getStats() {
        return null;
    }
    
    /**
     * Rebuild bloom filter for performance optimization
     */
    private final void rebuildBloomFilter() {
    }
    
    /**
     * Extract domain from a pattern (best effort)
     */
    private final java.lang.String extractDomainFromPattern(java.lang.String pattern) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/auraview/adblocker/filter/FilterEngine$Companion;", "", "()V", "TAG", "", "instance", "Lcom/auraview/adblocker/filter/FilterEngine;", "instanceMutex", "Lkotlinx/coroutines/sync/Mutex;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized()
        @org.jetbrains.annotations.NotNull()
        public final synchronized com.auraview.adblocker.filter.FilterEngine getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    /**
     * Filter statistics data class
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/auraview/adblocker/filter/FilterEngine$FilterStats;", "", "totalRules", "", "domainRules", "wildcardRules", "regexRules", "exceptionRules", "lastUpdateTime", "", "bloomFilterSize", "(IIIIIJI)V", "getBloomFilterSize", "()I", "getDomainRules", "getExceptionRules", "getLastUpdateTime", "()J", "getRegexRules", "getTotalRules", "getWildcardRules", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class FilterStats {
        private final int totalRules = 0;
        private final int domainRules = 0;
        private final int wildcardRules = 0;
        private final int regexRules = 0;
        private final int exceptionRules = 0;
        private final long lastUpdateTime = 0L;
        private final int bloomFilterSize = 0;
        
        public FilterStats(int totalRules, int domainRules, int wildcardRules, int regexRules, int exceptionRules, long lastUpdateTime, int bloomFilterSize) {
            super();
        }
        
        public final int getTotalRules() {
            return 0;
        }
        
        public final int getDomainRules() {
            return 0;
        }
        
        public final int getWildcardRules() {
            return 0;
        }
        
        public final int getRegexRules() {
            return 0;
        }
        
        public final int getExceptionRules() {
            return 0;
        }
        
        public final long getLastUpdateTime() {
            return 0L;
        }
        
        public final int getBloomFilterSize() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final long component6() {
            return 0L;
        }
        
        public final int component7() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.filter.FilterEngine.FilterStats copy(int totalRules, int domainRules, int wildcardRules, int regexRules, int exceptionRules, long lastUpdateTime, int bloomFilterSize) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * Simple Bloom Filter implementation for fast lookups
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/auraview/adblocker/filter/FilterEngine$SimpleBloomFilter;", "", "expectedInsertions", "", "falsePositiveRate", "", "(ID)V", "bitArray", "", "numBits", "numHashFunctions", "size", "getSize", "()I", "add", "", "item", "", "getHashes", "", "mightContain", "", "app_debug"})
    static final class SimpleBloomFilter {
        private final int expectedInsertions = 0;
        private final double falsePositiveRate = 0.0;
        private final int numBits = 0;
        private final int numHashFunctions = 0;
        @org.jetbrains.annotations.NotNull()
        private final boolean[] bitArray = null;
        
        public SimpleBloomFilter(int expectedInsertions, double falsePositiveRate) {
            super();
        }
        
        public final int getSize() {
            return 0;
        }
        
        public final void add(@org.jetbrains.annotations.NotNull()
        java.lang.String item) {
        }
        
        public final boolean mightContain(@org.jetbrains.annotations.NotNull()
        java.lang.String item) {
            return false;
        }
        
        private final java.util.List<java.lang.Integer> getHashes(java.lang.String item) {
            return null;
        }
    }
}