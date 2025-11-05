package com.auraview.adblocker.filter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 82\u00020\u0001:\u000289B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JU\u0010\u0012\u001a\u00020\u00112M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00110\u000eJ\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f0\u001eJ\u000e\u0010 \u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010!J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\'\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J(\u0010+\u001a\u00020\u00112 \u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00110\u000eJ\u001e\u0010,\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u0010\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u000200J\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u001eH\u0086@\u00a2\u0006\u0002\u0010!J\u001e\u00102\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u00103J \u00104\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000200H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00110\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/auraview/adblocker/filter/FilterUpdateManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheDir", "Ljava/io/File;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "httpClient", "Lokhttp3/OkHttpClient;", "metadataFile", "updateListeners", "", "Lkotlin/Function3;", "", "", "", "addUpdateListener", "listener", "Lkotlin/ParameterName;", "name", "filterName", "success", "error", "cancelPeriodicUpdates", "clearCache", "downloadFilterList", "url", "getFilterMetadata", "", "Lcom/auraview/adblocker/filter/FilterUpdateManager$FilterMetadata;", "loadCachedFilters", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFilterFromCache", "", "Lcom/auraview/adblocker/filter/FilterRule;", "loadMetadata", "notifyUpdateFailed", "notifyUpdateStarted", "notifyUpdateSuccess", "parseFilterList", "content", "removeUpdateListener", "saveFilterToCache", "rules", "schedulePeriodicUpdates", "intervalHours", "", "updateAllFilters", "updateFilterList", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMetadata", "lastUpdate", "", "ruleCount", "Companion", "FilterMetadata", "app_debug"})
public final class FilterUpdateManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FilterUpdateManager";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String UPDATE_WORK_NAME = "filter_update_work";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CACHE_DIR = "filter_cache";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String METADATA_FILE = "filter_metadata.json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String UBLOCK_BASE_URL = "https://raw.githubusercontent.com/uBlockOrigin/uAssets/master/filters/";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.String> DEFAULT_FILTER_LISTS = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient httpClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File cacheDir = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File metadataFile = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.jvm.functions.Function3<java.lang.String, java.lang.Boolean, java.lang.String, kotlin.Unit>> updateListeners = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.filter.FilterUpdateManager.Companion Companion = null;
    
    public FilterUpdateManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Add an update listener
     */
    public final void addUpdateListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> listener) {
    }
    
    /**
     * Remove an update listener
     */
    public final void removeUpdateListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> listener) {
    }
    
    /**
     * Update a specific filter list
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFilterList(@org.jetbrains.annotations.NotNull()
    java.lang.String filterName, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Update all default filter lists
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAllFilters(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.Boolean>> $completion) {
        return null;
    }
    
    /**
     * Load cached filter lists into the filter engine
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loadCachedFilters(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Schedule periodic filter updates
     */
    public final void schedulePeriodicUpdates(int intervalHours) {
    }
    
    /**
     * Cancel periodic updates
     */
    public final void cancelPeriodicUpdates() {
    }
    
    /**
     * Get filter metadata
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.auraview.adblocker.filter.FilterUpdateManager.FilterMetadata> getFilterMetadata() {
        return null;
    }
    
    /**
     * Clear all cached filters
     */
    public final void clearCache() {
    }
    
    private final java.lang.String downloadFilterList(java.lang.String url) {
        return null;
    }
    
    private final java.util.List<com.auraview.adblocker.filter.FilterRule> parseFilterList(java.lang.String content, java.lang.String filterName) {
        return null;
    }
    
    private final void saveFilterToCache(java.lang.String filterName, java.util.List<com.auraview.adblocker.filter.FilterRule> rules) {
    }
    
    private final java.util.List<com.auraview.adblocker.filter.FilterRule> loadFilterFromCache(java.lang.String filterName) {
        return null;
    }
    
    private final void updateMetadata(java.lang.String filterName, long lastUpdate, int ruleCount) {
    }
    
    private final java.util.Map<java.lang.String, com.auraview.adblocker.filter.FilterUpdateManager.FilterMetadata> loadMetadata() {
        return null;
    }
    
    private final void notifyUpdateStarted(java.lang.String filterName) {
    }
    
    private final void notifyUpdateSuccess(java.lang.String filterName) {
    }
    
    private final void notifyUpdateFailed(java.lang.String filterName, java.lang.String error) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/auraview/adblocker/filter/FilterUpdateManager$Companion;", "", "()V", "CACHE_DIR", "", "DEFAULT_FILTER_LISTS", "", "getDEFAULT_FILTER_LISTS", "()Ljava/util/Map;", "METADATA_FILE", "TAG", "UBLOCK_BASE_URL", "UPDATE_WORK_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.lang.String> getDEFAULT_FILTER_LISTS() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/auraview/adblocker/filter/FilterUpdateManager$FilterMetadata;", "", "lastUpdate", "", "ruleCount", "", "(JI)V", "getLastUpdate", "()J", "getRuleCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class FilterMetadata {
        private final long lastUpdate = 0L;
        private final int ruleCount = 0;
        
        public FilterMetadata(long lastUpdate, int ruleCount) {
            super();
        }
        
        public final long getLastUpdate() {
            return 0L;
        }
        
        public final int getRuleCount() {
            return 0;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.filter.FilterUpdateManager.FilterMetadata copy(long lastUpdate, int ruleCount) {
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