package com.auraview.adblocker.vpn

import android.content.Context
import android.content.Intent
import android.net.VpnService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VpnController(private val context: Context) {

    enum class VpnState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        ERROR
    }

    private val _vpnState = MutableLiveData<VpnState>(VpnState.DISCONNECTED)
    val vpnState: LiveData<VpnState> = _vpnState

    private val _connectionTime = MutableLiveData<Long>(0)
    val connectionTime: LiveData<Long> = _connectionTime

    private var connectionStartTime: Long = 0

    companion object {
        private var instance: VpnController? = null

        fun getInstance(context: Context): VpnController {
            return instance ?: VpnController(context.applicationContext).also { instance = it }
        }
    }

    init {
        // Check current VPN state on initialization
        updateVpnState()
    }

    fun startVpn(): Boolean {
        return try {
            _vpnState.value = VpnState.CONNECTING

            val vpnIntent = VpnService.prepare(context)
            if (vpnIntent != null) {
                // User needs to grant permission
                _vpnState.value = VpnState.DISCONNECTED
                return false
            }

            // Start the VPN service
            val serviceIntent = Intent(context, AuraViewVpnService::class.java)
            context.startService(serviceIntent)

            connectionStartTime = System.currentTimeMillis()
            startConnectionTimer()

            true
        } catch (e: Exception) {
            _vpnState.value = VpnState.ERROR
            false
        }
    }

    fun stopVpn() {
        try {
            _vpnState.value = VpnState.DISCONNECTING

            val serviceIntent = Intent(context, AuraViewVpnService::class.java).apply {
                action = AuraViewVpnService.ACTION_STOP_VPN
            }
            context.startService(serviceIntent)

            stopConnectionTimer()
            _connectionTime.value = 0

        } catch (e: Exception) {
            _vpnState.value = VpnState.ERROR
        }
    }

    fun getVpnPermissionIntent(): Intent? {
        return VpnService.prepare(context)
    }

    fun onVpnConnected() {
        _vpnState.value = VpnState.CONNECTED
        connectionStartTime = System.currentTimeMillis()
        startConnectionTimer()
    }

    fun onVpnDisconnected() {
        _vpnState.value = VpnState.DISCONNECTED
        stopConnectionTimer()
        _connectionTime.value = 0
    }

    fun onVpnError() {
        _vpnState.value = VpnState.ERROR
        stopConnectionTimer()
        _connectionTime.value = 0
    }

    private fun updateVpnState() {
        // Check if VPN service is running
        // This is a simplified check - in production you'd check the actual service state
        val isVpnActive = isVpnServiceRunning()
        _vpnState.value = if (isVpnActive) VpnState.CONNECTED else VpnState.DISCONNECTED
    }

    private fun isVpnServiceRunning(): Boolean {
        // Check if our VPN service is running
        // This would typically involve checking the system VPN state
        return false // Placeholder - implement actual check
    }

    private fun startConnectionTimer() {
        // Start a coroutine to update connection time every second
        // Implementation would use a coroutine timer
    }

    private fun stopConnectionTimer() {
        // Stop the connection timer
        // Implementation would cancel the coroutine
    }

    fun getConnectionDuration(): Long {
        return if (connectionStartTime > 0) {
            System.currentTimeMillis() - connectionStartTime
        } else {
            0
        }
    }

    fun isVpnActive(): Boolean {
        return _vpnState.value == VpnState.CONNECTED
    }

    fun getStateString(): String {
        return when (_vpnState.value) {
            VpnState.CONNECTED -> "Protection Active"
            VpnState.CONNECTING -> "Connecting..."
            VpnState.DISCONNECTING -> "Disconnecting..."
            VpnState.ERROR -> "Connection Error"
            else -> "Protection Disabled"
        }
    }
}
