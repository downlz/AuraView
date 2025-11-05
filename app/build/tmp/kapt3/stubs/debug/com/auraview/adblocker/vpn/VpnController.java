package com.auraview.adblocker.vpn;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u0017J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0006\u0010 \u001a\u00020\u001aJ\b\u0010!\u001a\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/auraview/adblocker/vpn/VpnController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_connectionTime", "Landroidx/lifecycle/MutableLiveData;", "", "_vpnState", "Lcom/auraview/adblocker/vpn/VpnController$VpnState;", "connectionStartTime", "connectionTime", "Landroidx/lifecycle/LiveData;", "getConnectionTime", "()Landroidx/lifecycle/LiveData;", "vpnState", "getVpnState", "getConnectionDuration", "getStateString", "", "getVpnPermissionIntent", "Landroid/content/Intent;", "isVpnActive", "", "isVpnServiceRunning", "onVpnConnected", "", "onVpnDisconnected", "onVpnError", "startConnectionTimer", "startVpn", "stopConnectionTimer", "stopVpn", "updateVpnState", "Companion", "VpnState", "app_debug"})
public final class VpnController {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.auraview.adblocker.vpn.VpnController.VpnState> _vpnState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.auraview.adblocker.vpn.VpnController.VpnState> vpnState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _connectionTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> connectionTime = null;
    private long connectionStartTime = 0L;
    @org.jetbrains.annotations.Nullable()
    private static com.auraview.adblocker.vpn.VpnController instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.vpn.VpnController.Companion Companion = null;
    
    public VpnController(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.auraview.adblocker.vpn.VpnController.VpnState> getVpnState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getConnectionTime() {
        return null;
    }
    
    public final boolean startVpn() {
        return false;
    }
    
    public final void stopVpn() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Intent getVpnPermissionIntent() {
        return null;
    }
    
    public final void onVpnConnected() {
    }
    
    public final void onVpnDisconnected() {
    }
    
    public final void onVpnError() {
    }
    
    private final void updateVpnState() {
    }
    
    private final boolean isVpnServiceRunning() {
        return false;
    }
    
    private final void startConnectionTimer() {
    }
    
    private final void stopConnectionTimer() {
    }
    
    public final long getConnectionDuration() {
        return 0L;
    }
    
    public final boolean isVpnActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStateString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/auraview/adblocker/vpn/VpnController$Companion;", "", "()V", "instance", "Lcom/auraview/adblocker/vpn/VpnController;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.vpn.VpnController getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/auraview/adblocker/vpn/VpnController$VpnState;", "", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "DISCONNECTING", "ERROR", "app_debug"})
    public static enum VpnState {
        /*public static final*/ DISCONNECTED /* = new DISCONNECTED() */,
        /*public static final*/ CONNECTING /* = new CONNECTING() */,
        /*public static final*/ CONNECTED /* = new CONNECTED() */,
        /*public static final*/ DISCONNECTING /* = new DISCONNECTING() */,
        /*public static final*/ ERROR /* = new ERROR() */;
        
        VpnState() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.auraview.adblocker.vpn.VpnController.VpnState> getEntries() {
            return null;
        }
    }
}