package com.auraview.adblocker.vpn;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 92\u00020\u0001:\u00039:;B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J2\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020 H\u0016J\b\u0010\'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0016J\"\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010/\u001a\u00020\"H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020\u0014H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u0014H\u0002J \u00102\u001a\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u00103J\u0018\u00104\u001a\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u00020 H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/auraview/adblocker/vpn/AuraViewVpnService;", "Landroid/net/VpnService;", "()V", "filterEngine", "Lcom/auraview/adblocker/filter/FilterEngine;", "isRunning", "", "queryLogger", "Lcom/auraview/adblocker/stats/QueryLogger;", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "vpnController", "Lcom/auraview/adblocker/vpn/VpnController;", "vpnInterface", "Landroid/os/ParcelFileDescriptor;", "createConfigureIntent", "Landroid/app/PendingIntent;", "createDnsResponse", "Ljava/nio/ByteBuffer;", "originalBuffer", "ipHeader", "Lcom/auraview/adblocker/vpn/AuraViewVpnService$IpHeader;", "udpPacket", "Lcom/auraview/adblocker/vpn/AuraViewVpnService$UdpPacket;", "domain", "", "isBlocked", "createNotification", "Landroid/app/Notification;", "createNotificationChannel", "", "extractDnsData", "", "buffer", "offset", "", "onCreate", "onDestroy", "onRevoke", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "parseDnsQuery", "dnsData", "parseIpHeader", "parseUdpPacket", "processDnsPacket", "(Ljava/nio/ByteBuffer;Lcom/auraview/adblocker/vpn/AuraViewVpnService$UdpPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPacket", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPacketProcessing", "startVpn", "stopVpn", "Companion", "IpHeader", "UdpPacket", "app_release"})
public final class AuraViewVpnService extends android.net.VpnService {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AuraViewVpnService";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_CHANNEL_ID = "auraview_vpn_channel";
    private static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP_VPN = "com.auraview.adblocker.STOP_VPN";
    @org.jetbrains.annotations.Nullable()
    private android.os.ParcelFileDescriptor vpnInterface;
    @org.jetbrains.annotations.Nullable()
    private com.auraview.adblocker.filter.FilterEngine filterEngine;
    @org.jetbrains.annotations.Nullable()
    private com.auraview.adblocker.stats.QueryLogger queryLogger;
    @org.jetbrains.annotations.Nullable()
    private com.auraview.adblocker.vpn.VpnController vpnController;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob serviceJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    private boolean isRunning = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.auraview.adblocker.vpn.AuraViewVpnService.Companion Companion = null;
    
    public AuraViewVpnService() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void startVpn() {
    }
    
    private final void stopVpn() {
    }
    
    private final void startPacketProcessing() {
    }
    
    private final java.lang.Object processPacket(java.nio.ByteBuffer buffer, kotlin.coroutines.Continuation<? super java.nio.ByteBuffer> $completion) {
        return null;
    }
    
    private final com.auraview.adblocker.vpn.AuraViewVpnService.IpHeader parseIpHeader(java.nio.ByteBuffer buffer) {
        return null;
    }
    
    private final com.auraview.adblocker.vpn.AuraViewVpnService.UdpPacket parseUdpPacket(java.nio.ByteBuffer buffer) {
        return null;
    }
    
    private final java.lang.Object processDnsPacket(java.nio.ByteBuffer buffer, com.auraview.adblocker.vpn.AuraViewVpnService.UdpPacket udpPacket, kotlin.coroutines.Continuation<? super java.nio.ByteBuffer> $completion) {
        return null;
    }
    
    private final byte[] extractDnsData(java.nio.ByteBuffer buffer, int offset) {
        return null;
    }
    
    private final java.lang.String parseDnsQuery(byte[] dnsData) {
        return null;
    }
    
    private final java.nio.ByteBuffer createDnsResponse(java.nio.ByteBuffer originalBuffer, com.auraview.adblocker.vpn.AuraViewVpnService.IpHeader ipHeader, com.auraview.adblocker.vpn.AuraViewVpnService.UdpPacket udpPacket, java.lang.String domain, boolean isBlocked) {
        return null;
    }
    
    private final android.app.PendingIntent createConfigureIntent() {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    private final android.app.Notification createNotification() {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onRevoke() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/auraview/adblocker/vpn/AuraViewVpnService$Companion;", "", "()V", "ACTION_STOP_VPN", "", "NOTIFICATION_CHANNEL_ID", "NOTIFICATION_ID", "", "TAG", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/auraview/adblocker/vpn/AuraViewVpnService$IpHeader;", "", "protocol", "", "headerLength", "(II)V", "getHeaderLength", "()I", "getProtocol", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    static final class IpHeader {
        private final int protocol = 0;
        private final int headerLength = 0;
        
        public IpHeader(int protocol, int headerLength) {
            super();
        }
        
        public final int getProtocol() {
            return 0;
        }
        
        public final int getHeaderLength() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.vpn.AuraViewVpnService.IpHeader copy(int protocol, int headerLength) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/auraview/adblocker/vpn/AuraViewVpnService$UdpPacket;", "", "sourcePort", "", "destinationPort", "(II)V", "getDestinationPort", "()I", "getSourcePort", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
    static final class UdpPacket {
        private final int sourcePort = 0;
        private final int destinationPort = 0;
        
        public UdpPacket(int sourcePort, int destinationPort) {
            super();
        }
        
        public final int getSourcePort() {
            return 0;
        }
        
        public final int getDestinationPort() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.auraview.adblocker.vpn.AuraViewVpnService.UdpPacket copy(int sourcePort, int destinationPort) {
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