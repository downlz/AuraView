package com.auraview.adblocker.vpn;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 52\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010!J\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000eJ\u001a\u0010&\u001a\u00020\'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010!J\u0006\u0010)\u001a\u00020\'J\u0006\u0010*\u001a\u00020\u0007J\b\u0010+\u001a\u00020\'H\u0002J\u0006\u0010,\u001a\u00020\'J\u000e\u0010-\u001a\u00020\'2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\'2\u0006\u0010.\u001a\u00020\u0007J\u000e\u00100\u001a\u00020\'2\u0006\u00101\u001a\u00020\fJ\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\'2\u0006\u00104\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013\u00a8\u00066"}, d2 = {"Lcom/auraview/adblocker/vpn/VpnStateManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_autoStartEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "_blockUdp53", "_connectionCount", "", "_dnsServer", "", "_lastConnectionTime", "", "_totalConnectionTime", "autoStartEnabled", "Landroidx/lifecycle/LiveData;", "getAutoStartEnabled", "()Landroidx/lifecycle/LiveData;", "blockUdp53", "getBlockUdp53", "connectionCount", "getConnectionCount", "dnsServer", "getDnsServer", "lastConnectionTime", "getLastConnectionTime", "prefs", "Landroid/content/SharedPreferences;", "totalConnectionTime", "getTotalConnectionTime", "exportSettings", "", "getFormattedConnectionTime", "millis", "getFormattedDataSize", "bytes", "importSettings", "", "settings", "incrementConnectionCount", "isAutoStartEnabled", "loadSettings", "resetStatistics", "setAutoStartEnabled", "enabled", "setBlockUdp53", "setDnsServer", "server", "shouldBlockUdp53", "updateConnectionTime", "duration", "Companion", "app_debug"})
public final class VpnStateManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "auraview_vpn_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AUTO_START = "auto_start_enabled";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_CONNECTION_TIME = "last_connection_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_CONNECTION_TIME = "total_connection_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CONNECTION_COUNT = "connection_count";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DNS_SERVER = "dns_server";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BLOCK_UDP = "block_udp_53";
    private static final boolean DEFAULT_AUTO_START = false;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_DNS_SERVER = "1.1.1.2";
    private static final boolean DEFAULT_BLOCK_UDP = true;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _autoStartEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> autoStartEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _lastConnectionTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> lastConnectionTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _totalConnectionTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> totalConnectionTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _connectionCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> connectionCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _dnsServer = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> dnsServer = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _blockUdp53 = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> blockUdp53 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.vpn.VpnStateManager.Companion Companion = null;
    
    public VpnStateManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAutoStartEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getLastConnectionTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getTotalConnectionTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getConnectionCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getDnsServer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getBlockUdp53() {
        return null;
    }
    
    private final void loadSettings() {
    }
    
    public final void setAutoStartEnabled(boolean enabled) {
    }
    
    public final boolean isAutoStartEnabled() {
        return false;
    }
    
    public final void updateConnectionTime(long duration) {
    }
    
    public final void incrementConnectionCount() {
    }
    
    public final void resetStatistics() {
    }
    
    public final void setDnsServer(@org.jetbrains.annotations.NotNull()
    java.lang.String server) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDnsServer() {
        return null;
    }
    
    public final void setBlockUdp53(boolean enabled) {
    }
    
    public final boolean shouldBlockUdp53() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedConnectionTime(long millis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedDataSize(long bytes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> exportSettings() {
        return null;
    }
    
    public final void importSettings(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> settings) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/auraview/adblocker/vpn/VpnStateManager$Companion;", "", "()V", "DEFAULT_AUTO_START", "", "DEFAULT_BLOCK_UDP", "DEFAULT_DNS_SERVER", "", "KEY_AUTO_START", "KEY_BLOCK_UDP", "KEY_CONNECTION_COUNT", "KEY_DNS_SERVER", "KEY_LAST_CONNECTION_TIME", "KEY_TOTAL_CONNECTION_TIME", "PREFS_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}