package com.auraview.adblocker.filter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003JG\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/auraview/adblocker/filter/FilterRule;", "", "pattern", "", "isRegex", "", "isDomainOnly", "isException", "options", "", "(Ljava/lang/String;ZZZLjava/util/Map;)V", "()Z", "getOptions", "()Ljava/util/Map;", "getPattern", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "matchesDomain", "domain", "shouldBlock", "requestType", "toString", "Companion", "app_release"})
public final class FilterRule {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pattern = null;
    private final boolean isRegex = false;
    private final boolean isDomainOnly = false;
    private final boolean isException = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> options = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_DOMAIN = "domain";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_THIRD_PARTY = "third-party";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_FIRST_PARTY = "first-party";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_SCRIPT = "script";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_IMAGE = "image";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_STYLESHEET = "stylesheet";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_OBJECT = "object";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_XMLHTTPREQUEST = "xmlhttprequest";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_OBJECT_SUBREQUEST = "object-subrequest";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_SUBDOCUMENT = "subdocument";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_DOCUMENT = "document";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_ELEMHIDE = "elemhide";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_GENERICHIDE = "generichide";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_GENERICBLOCK = "genericblock";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_POPUP = "popup";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPTION_OTHER = "other";
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.filter.FilterRule.Companion Companion = null;
    
    public FilterRule(@org.jetbrains.annotations.NotNull()
    java.lang.String pattern, boolean isRegex, boolean isDomainOnly, boolean isException, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> options) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPattern() {
        return null;
    }
    
    public final boolean isRegex() {
        return false;
    }
    
    public final boolean isDomainOnly() {
        return false;
    }
    
    public final boolean isException() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getOptions() {
        return null;
    }
    
    public final boolean matchesDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String domain) {
        return false;
    }
    
    public final boolean shouldBlock(@org.jetbrains.annotations.NotNull()
    java.lang.String requestType) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.auraview.adblocker.filter.FilterRule copy(@org.jetbrains.annotations.NotNull()
    java.lang.String pattern, boolean isRegex, boolean isDomainOnly, boolean isException, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> options) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/auraview/adblocker/filter/FilterRule$Companion;", "", "()V", "OPTION_DOCUMENT", "", "OPTION_DOMAIN", "OPTION_ELEMHIDE", "OPTION_FIRST_PARTY", "OPTION_GENERICBLOCK", "OPTION_GENERICHIDE", "OPTION_IMAGE", "OPTION_OBJECT", "OPTION_OBJECT_SUBREQUEST", "OPTION_OTHER", "OPTION_POPUP", "OPTION_SCRIPT", "OPTION_STYLESHEET", "OPTION_SUBDOCUMENT", "OPTION_THIRD_PARTY", "OPTION_XMLHTTPREQUEST", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}