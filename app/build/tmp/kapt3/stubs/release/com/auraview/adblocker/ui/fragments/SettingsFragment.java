package com.auraview.adblocker.ui.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/auraview/adblocker/ui/fragments/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "autoStartSwitch", "Landroid/widget/Switch;", "backButton", "Landroid/widget/Button;", "blockUdpSwitch", "dnsCloudflareButton", "dnsGoogleButton", "dnsQuad9Button", "dnsServerText", "Landroid/widget/TextView;", "saveButton", "updateDailyButton", "updateFrequencyText", "updateWeeklyButton", "vpnStateManager", "Lcom/auraview/adblocker/vpn/VpnStateManager;", "getDnsServerDisplayName", "", "server", "initializeViews", "", "view", "Landroid/view/View;", "loadCurrentSettings", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "saveSettings", "selectDnsServer", "selectUpdateFrequency", "frequency", "setupClickListeners", "updateDnsButtonStates", "selectedServer", "app_release"})
public final class SettingsFragment extends androidx.fragment.app.Fragment {
    private android.widget.Button backButton;
    private android.widget.Button saveButton;
    private android.widget.Switch autoStartSwitch;
    private android.widget.Switch blockUdpSwitch;
    private android.widget.TextView dnsServerText;
    private android.widget.Button dnsCloudflareButton;
    private android.widget.Button dnsGoogleButton;
    private android.widget.Button dnsQuad9Button;
    private android.widget.TextView updateFrequencyText;
    private android.widget.Button updateDailyButton;
    private android.widget.Button updateWeeklyButton;
    private com.auraview.adblocker.vpn.VpnStateManager vpnStateManager;
    
    public SettingsFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void loadCurrentSettings() {
    }
    
    private final void selectDnsServer(java.lang.String server) {
    }
    
    private final java.lang.String getDnsServerDisplayName(java.lang.String server) {
        return null;
    }
    
    private final void updateDnsButtonStates(java.lang.String selectedServer) {
    }
    
    private final void selectUpdateFrequency(java.lang.String frequency) {
    }
    
    private final void saveSettings() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}