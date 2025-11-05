package com.auraview.adblocker.stats;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0004+,-.B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u001e\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010&J\b\u0010\'\u001a\u00020!H\u0002J\u000e\u0010(\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/auraview/adblocker/stats/QueryLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blockedQueries", "Ljava/util/concurrent/atomic/AtomicInteger;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "domainStats", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/auraview/adblocker/stats/QueryLogger$DomainStat;", "estimatedDataSaved", "Ljava/util/concurrent/atomic/AtomicLong;", "logFile", "Ljava/io/File;", "logMutex", "Lkotlinx/coroutines/sync/Mutex;", "prefs", "Landroid/content/SharedPreferences;", "startTime", "", "totalQueries", "getStatistics", "Lcom/auraview/adblocker/stats/QueryLogger$QueryStatistics;", "getTopAllowedDomains", "", "Lcom/auraview/adblocker/stats/QueryLogger$DomainCount;", "limit", "", "getTopBlockedDomains", "loadPersistedStats", "", "logQuery", "domain", "wasBlocked", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistStats", "resetStatistics", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDomainStats", "Companion", "DomainCount", "DomainStat", "QueryStatistics", "app_release"})
public final class QueryLogger {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "QueryLogger";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "auraview_query_stats";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOG_FILE_NAME = "query_log.json";
    private static final int MAX_LOG_ENTRIES = 10000;
    @org.jetbrains.annotations.Nullable()
    private static com.auraview.adblocker.stats.QueryLogger instance;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.sync.Mutex instanceMutex = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File logFile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex logMutex = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicInteger totalQueries = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicInteger blockedQueries = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicLong estimatedDataSaved = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.auraview.adblocker.stats.QueryLogger.DomainStat> domainStats = null;
    private final long startTime = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.stats.QueryLogger.Companion Companion = null;
    
    private QueryLogger(android.content.Context context) {
        super();
    }
    
    /**
     * Log a DNS query
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String domain, boolean wasBlocked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<java.lang.Object> $completion) {
        return null;
    }
    
    /**
     * Get current statistics
     */
    @org.jetbrains.annotations.NotNull()
    public final com.auraview.adblocker.stats.QueryLogger.QueryStatistics getStatistics() {
        return null;
    }
    
    /**
     * Reset all statistics
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resetStatistics(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Get top blocked domains
     */
    private final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> getTopBlockedDomains(int limit) {
        return null;
    }
    
    /**
     * Get top allowed domains
     */
    private final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> getTopAllowedDomains(int limit) {
        return null;
    }
    
    /**
     * Update domain statistics
     */
    private final void updateDomainStats(java.lang.String domain, boolean wasBlocked) {
    }
    
    /**
     * Persist statistics to storage
     */
    private final void persistStats() {
    }
    
    /**
     * Load persisted statistics
     */
    private final void loadPersistedStats() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/auraview/adblocker/stats/QueryLogger$Companion;", "", "()V", "LOG_FILE_NAME", "", "MAX_LOG_ENTRIES", "", "PREFS_NAME", "TAG", "instance", "Lcom/auraview/adblocker/stats/QueryLogger;", "instanceMutex", "Lkotlinx/coroutines/sync/Mutex;", "getInstance", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized()
        @org.jetbrains.annotations.NotNull()
        public final synchronized com.auraview.adblocker.stats.QueryLogger getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/auraview/adblocker/stats/QueryLogger$DomainCount;", "", "domain", "", "count", "", "(Ljava/lang/String;I)V", "getCount", "()I", "getDomain", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
    public static final class DomainCount {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String domain = null;
        private final int count = 0;
        
        public DomainCount(@org.jetbrains.annotations.NotNull()
        java.lang.String domain, int count) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDomain() {
            return null;
        }
        
        public final int getCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.stats.QueryLogger.DomainCount copy(@org.jetbrains.annotations.NotNull()
        java.lang.String domain, int count) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/auraview/adblocker/stats/QueryLogger$DomainStat;", "", "domain", "", "blockedCount", "", "allowedCount", "(Ljava/lang/String;II)V", "getAllowedCount", "()I", "setAllowedCount", "(I)V", "getBlockedCount", "setBlockedCount", "getDomain", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
    static final class DomainStat {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String domain = null;
        private int blockedCount;
        private int allowedCount;
        
        public DomainStat(@org.jetbrains.annotations.NotNull()
        java.lang.String domain, int blockedCount, int allowedCount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDomain() {
            return null;
        }
        
        public final int getBlockedCount() {
            return 0;
        }
        
        public final void setBlockedCount(int p0) {
        }
        
        public final int getAllowedCount() {
            return 0;
        }
        
        public final void setAllowedCount(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.stats.QueryLogger.DomainStat copy(@org.jetbrains.annotations.NotNull()
        java.lang.String domain, int blockedCount, int allowedCount) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006&"}, d2 = {"Lcom/auraview/adblocker/stats/QueryLogger$QueryStatistics;", "", "totalQueries", "", "blockedQueries", "allowedQueries", "estimatedDataSaved", "", "timeRange", "topBlockedDomains", "", "Lcom/auraview/adblocker/stats/QueryLogger$DomainCount;", "topAllowedDomains", "(IIIJJLjava/util/List;Ljava/util/List;)V", "getAllowedQueries", "()I", "getBlockedQueries", "getEstimatedDataSaved", "()J", "getTimeRange", "getTopAllowedDomains", "()Ljava/util/List;", "getTopBlockedDomains", "getTotalQueries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    public static final class QueryStatistics {
        private final int totalQueries = 0;
        private final int blockedQueries = 0;
        private final int allowedQueries = 0;
        private final long estimatedDataSaved = 0L;
        private final long timeRange = 0L;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topBlockedDomains = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topAllowedDomains = null;
        
        public QueryStatistics(int totalQueries, int blockedQueries, int allowedQueries, long estimatedDataSaved, long timeRange, @org.jetbrains.annotations.NotNull()
        java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topBlockedDomains, @org.jetbrains.annotations.NotNull()
        java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topAllowedDomains) {
            super();
        }
        
        public final int getTotalQueries() {
            return 0;
        }
        
        public final int getBlockedQueries() {
            return 0;
        }
        
        public final int getAllowedQueries() {
            return 0;
        }
        
        public final long getEstimatedDataSaved() {
            return 0L;
        }
        
        public final long getTimeRange() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> getTopBlockedDomains() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> getTopAllowedDomains() {
            return null;
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
        
        public final long component4() {
            return 0L;
        }
        
        public final long component5() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.stats.QueryLogger.QueryStatistics copy(int totalQueries, int blockedQueries, int allowedQueries, long estimatedDataSaved, long timeRange, @org.jetbrains.annotations.NotNull()
        java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topBlockedDomains, @org.jetbrains.annotations.NotNull()
        java.util.List<com.auraview.adblocker.stats.QueryLogger.DomainCount> topAllowedDomains) {
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
}