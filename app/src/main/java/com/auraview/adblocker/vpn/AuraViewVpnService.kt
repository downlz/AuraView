package com.auraview.adblocker.vpn

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.net.VpnService
import android.os.Build
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.core.app.NotificationCompat
import com.auraview.adblocker.R
import com.auraview.adblocker.filter.FilterEngine
import com.auraview.adblocker.stats.QueryLogger
import com.auraview.adblocker.ui.MainActivity
import kotlinx.coroutines.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

class AuraViewVpnService : VpnService() {

    companion object {
        private const val TAG = "AuraViewVpnService"
        private const val NOTIFICATION_CHANNEL_ID = "auraview_vpn_channel"
        private const val NOTIFICATION_ID = 1
        const val ACTION_STOP_VPN = "com.auraview.adblocker.STOP_VPN"
    }

    private var vpnInterface: ParcelFileDescriptor? = null
    private var filterEngine: FilterEngine? = null
    private var queryLogger: QueryLogger? = null
    private var vpnController: VpnController? = null
    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)

    private var isRunning = false

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "AuraViewVpnService created")

        // Initialize components
        filterEngine = FilterEngine.getInstance(this)
        queryLogger = QueryLogger.getInstance(this)
        vpnController = VpnController.getInstance(this)

        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ${intent?.action}")

        when (intent?.action) {
            ACTION_STOP_VPN -> {
                stopVpn()
                return START_NOT_STICKY
            }
            else -> {
                if (!isRunning) {
                    startVpn()
                }
                return START_STICKY
            }
        }
    }

    private fun startVpn() {
        Log.d(TAG, "Starting VPN service")

        try {
            // Build VPN interface
            val builder = Builder()
                .setSession("AuraView VPN")
                .setConfigureIntent(createConfigureIntent())
                .addAddress("10.0.0.2", 32)
                .addRoute("0.0.0.0", 0)
                .addDnsServer("1.1.1.2")  // Cloudflare private DNS (security.cloudflare-dns.com)
                .setBlocking(true)

            // Create the VPN interface
            vpnInterface = builder.establish()

            if (vpnInterface != null) {
                isRunning = true
                startForeground(NOTIFICATION_ID, createNotification())
                startPacketProcessing()
                // Notify controller that VPN is connected
                vpnController?.onVpnConnected()
                Log.d(TAG, "VPN service started successfully")
            } else {
                Log.e(TAG, "Failed to establish VPN interface")
                vpnController?.onVpnError()
                stopSelf()
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error starting VPN", e)
            stopSelf()
        }
    }

    private fun stopVpn() {
        Log.d(TAG, "Stopping VPN service")

        isRunning = false
        serviceJob.cancel()

        vpnInterface?.close()
        vpnInterface = null

        // Notify controller that VPN is disconnected
        vpnController?.onVpnDisconnected()

        stopForeground(true)
        stopSelf()
    }

    private fun startPacketProcessing() {
        serviceScope.launch {
            try {
                val inputStream = FileInputStream(vpnInterface?.fileDescriptor)
                val outputStream = FileOutputStream(vpnInterface?.fileDescriptor)

                val buffer = ByteBuffer.allocate(32767)

                while (isRunning && isActive) {
                    try {
                        // Read packet from VPN interface
                        val length = inputStream.read(buffer.array())
                        if (length > 0) {
                            buffer.limit(length)

                            // Process the packet
                            val processedPacket = processPacket(buffer)
                            if (processedPacket != null) {
                                // Write processed packet back
                                outputStream.write(processedPacket.array(), 0, processedPacket.limit())
                            }

                            buffer.clear()
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Error processing packet", e)
                        break
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error in packet processing loop", e)
            }
        }
    }

    private suspend fun processPacket(buffer: ByteBuffer): ByteBuffer? {
        try {
            // Parse IP packet header
            val ipHeader = parseIpHeader(buffer)
            if (ipHeader == null) return buffer

            // Check if this is a DNS packet (UDP port 53)
            if (ipHeader.protocol == 17) { // UDP
                val udpPacket = parseUdpPacket(buffer)
                if (udpPacket != null && (udpPacket.destinationPort == 53 || udpPacket.sourcePort == 53)) {
                    return processDnsPacket(buffer, udpPacket)
                }
            }

            // For non-DNS packets, pass through
            return buffer

        } catch (e: Exception) {
            Log.e(TAG, "Error processing packet", e)
            return buffer
        }
    }

    private fun parseIpHeader(buffer: ByteBuffer): IpHeader? {
        if (buffer.limit() < 20) return null

        val versionAndIHL = buffer.get(0).toInt()
        val version = versionAndIHL shr 4
        if (version != 4) return null // Only IPv4 for now

        val ihl = versionAndIHL and 0x0F
        val headerLength = ihl * 4

        if (buffer.limit() < headerLength) return null

        val protocol = buffer.get(9).toInt()

        return IpHeader(protocol, headerLength)
    }

    private fun parseUdpPacket(buffer: ByteBuffer): UdpPacket? {
        val ipHeader = parseIpHeader(buffer) ?: return null

        if (buffer.limit() < ipHeader.headerLength + 8) return null

        buffer.position(ipHeader.headerLength)
        val sourcePort = ((buffer.get().toInt() and 0xFF) shl 8) or (buffer.get().toInt() and 0xFF)
        val destinationPort = ((buffer.get().toInt() and 0xFF) shl 8) or (buffer.get().toInt() and 0xFF)

        return UdpPacket(sourcePort, destinationPort)
    }

    private suspend fun processDnsPacket(buffer: ByteBuffer, udpPacket: UdpPacket): ByteBuffer? {
        try {
            val ipHeader = parseIpHeader(buffer) ?: return buffer
            val dnsData = extractDnsData(buffer, ipHeader.headerLength + 8)

            if (dnsData.isNotEmpty()) {
                val domain = parseDnsQuery(dnsData)
                if (domain != null) {
                    // Log the query
                    queryLogger?.logQuery(domain, false)

                    // Check if domain should be blocked
                    val shouldBlock = filterEngine?.shouldBlock(domain) ?: false

                    if (shouldBlock) {
                        // Log blocked query
                        queryLogger?.logQuery(domain, true)

                        // Return NXDOMAIN response
                        return createDnsResponse(buffer, ipHeader, udpPacket, domain, true)
                    }
                }
            }

            // Allow the query to proceed
            return buffer

        } catch (e: Exception) {
            Log.e(TAG, "Error processing DNS packet", e)
            return buffer
        }
    }

    private fun extractDnsData(buffer: ByteBuffer, offset: Int): ByteArray {
        if (buffer.limit() < offset + 12) return byteArrayOf()

        val dnsData = ByteArray(buffer.limit() - offset)
        buffer.position(offset)
        buffer.get(dnsData)
        return dnsData
    }

    private fun parseDnsQuery(dnsData: ByteArray): String? {
        if (dnsData.size < 12) return null

        try {
            var position = 12 // Skip DNS header
            val domain = StringBuilder()

            while (position < dnsData.size && dnsData[position].toInt() != 0) {
                val length = dnsData[position].toInt()
                if (length == 0 || position + length + 1 >= dnsData.size) break

                if (domain.isNotEmpty()) domain.append(".")

                domain.append(String(dnsData, position + 1, length))
                position += length + 1
            }

            return if (domain.isNotEmpty()) domain.toString() else null

        } catch (e: Exception) {
            Log.e(TAG, "Error parsing DNS query", e)
            return null
        }
    }

    private fun createDnsResponse(
        originalBuffer: ByteBuffer,
        ipHeader: IpHeader,
        udpPacket: UdpPacket,
        domain: String,
        isBlocked: Boolean
    ): ByteBuffer? {
        // For simplicity, create a basic NXDOMAIN response
        // In a full implementation, this would create proper DNS response packets
        return if (isBlocked) {
            // Return null to drop the packet (effectively blocking it)
            null
        } else {
            originalBuffer
        }
    }

    private fun createConfigureIntent(): PendingIntent {
        val intent = Intent(this, MainActivity::class.java)
        return PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "AuraView VPN Service",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "AuraView VPN protection notification"
                setShowBadge(false)
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): Notification {
        val stopIntent = Intent(this, AuraViewVpnService::class.java).apply {
            action = ACTION_STOP_VPN
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 0, stopIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.vpn_service_name))
            .setContentText(getString(R.string.vpn_service_description))
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
            .addAction(R.drawable.ic_launcher_foreground, "Stop", stopPendingIntent)
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AuraViewVpnService destroyed")
        stopVpn()
        serviceJob.cancel()
    }

    override fun onRevoke() {
        Log.d(TAG, "VPN permission revoked")
        stopVpn()
    }

    // Data classes for packet parsing
    private data class IpHeader(val protocol: Int, val headerLength: Int)
    private data class UdpPacket(val sourcePort: Int, val destinationPort: Int)
}
