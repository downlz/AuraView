package com.auraview.adblocker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\nH\u0002J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\nH\u0014J\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\nH\u0002J\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/auraview/adblocker/ui/MainActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "filterUpdateManager", "Lcom/auraview/adblocker/filter/FilterUpdateManager;", "vpnController", "Lcom/auraview/adblocker/vpn/VpnController;", "getFilterUpdateManager", "getVpnController", "goBack", "", "navigateToFragment", "fragmentTag", "", "observeVpnState", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestVpnPermission", "showVpnPermissionError", "startVpn", "stopVpn", "updateVpnStatusDisplay", "state", "Lcom/auraview/adblocker/vpn/VpnController$VpnState;", "Companion", "app_release"})
public final class MainActivity extends androidx.fragment.app.FragmentActivity {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MainActivity";
    private static final int REQUEST_VPN_PERMISSION = 100;
    private com.auraview.adblocker.vpn.VpnController vpnController;
    private com.auraview.adblocker.filter.FilterUpdateManager filterUpdateManager;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.ui.MainActivity.Companion Companion = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * Request VPN permission from user
     */
    public final void requestVpnPermission() {
    }
    
    /**
     * Start VPN service
     */
    public final void startVpn() {
    }
    
    /**
     * Stop VPN service
     */
    public final void stopVpn() {
    }
    
    /**
     * Get VPN controller instance
     */
    @org.jetbrains.annotations.NotNull()
    public final com.auraview.adblocker.vpn.VpnController getVpnController() {
        return null;
    }
    
    /**
     * Get filter update manager instance
     */
    @org.jetbrains.annotations.NotNull()
    public final com.auraview.adblocker.filter.FilterUpdateManager getFilterUpdateManager() {
        return null;
    }
    
    /**
     * Navigate to a specific fragment
     */
    public final void navigateToFragment(@org.jetbrains.annotations.NotNull()
    java.lang.String fragmentTag) {
    }
    
    /**
     * Go back to previous fragment
     */
    public final void goBack() {
    }
    
    private final void observeVpnState() {
    }
    
    private final void updateVpnStatusDisplay(com.auraview.adblocker.vpn.VpnController.VpnState state) {
    }
    
    private final void showVpnPermissionError() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/auraview/adblocker/ui/MainActivity$Companion;", "", "()V", "REQUEST_VPN_PERMISSION", "", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}