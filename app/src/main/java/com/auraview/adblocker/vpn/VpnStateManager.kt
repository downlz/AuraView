package com.auraview.adblocker.vpn

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VpnStateManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "auraview_vpn_prefs"
        private const val KEY_AUTO_START = "auto_start_enabled"
        private const val KEY_LAST_CONNECTION_TIME = "last_connection_time"
        private const val KEY_TOTAL_CONNECTION_TIME = "total_connection_time"
        private const val KEY_CONNECTION_COUNT = "connection_count"
        private const val KEY_DNS_SERVER = "dns_server"
        private const val KEY_BLOCK_UDP = "block_udp_53"

        // Default values
        private const val DEFAULT_AUTO_START = false
        private const val DEFAULT_DNS_SERVER = "1.1.1.2"  // Cloudflare private DNS
        private const val DEFAULT_BLOCK_UDP = true
    }

    // Auto-start settings
    private val _autoStartEnabled = MutableLiveData<Boolean>()
    val autoStartEnabled: LiveData<Boolean> = _autoStartEnabled

    // Connection statistics
    private val _lastConnectionTime = MutableLiveData<Long>()
    val lastConnectionTime: LiveData<Long> = _lastConnectionTime

    private val _totalConnectionTime = MutableLiveData<Long>()
    val totalConnectionTime: LiveData<Long> = _totalConnectionTime

    private val _connectionCount = MutableLiveData<Int>()
    val connectionCount: LiveData<Int> = _connectionCount

    // DNS settings
    private val _dnsServer = MutableLiveData<String>()
    val dnsServer: LiveData<String> = _dnsServer

    // Advanced settings
    private val _blockUdp53 = MutableLiveData<Boolean>()
    val blockUdp53: LiveData<Boolean> = _blockUdp53

    init {
        loadSettings()
    }

    private fun loadSettings() {
        _autoStartEnabled.value = prefs.getBoolean(KEY_AUTO_START, DEFAULT_AUTO_START)
        _lastConnectionTime.value = prefs.getLong(KEY_LAST_CONNECTION_TIME, 0)
        _totalConnectionTime.value = prefs.getLong(KEY_TOTAL_CONNECTION_TIME, 0)
        _connectionCount.value = prefs.getInt(KEY_CONNECTION_COUNT, 0)
        _dnsServer.value = prefs.getString(KEY_DNS_SERVER, DEFAULT_DNS_SERVER)
        _blockUdp53.value = prefs.getBoolean(KEY_BLOCK_UDP, DEFAULT_BLOCK_UDP)
    }

    // Auto-start management
    fun setAutoStartEnabled(enabled: Boolean) {
        _autoStartEnabled.value = enabled
        prefs.edit().putBoolean(KEY_AUTO_START, enabled).apply()
    }

    fun isAutoStartEnabled(): Boolean {
        return _autoStartEnabled.value ?: DEFAULT_AUTO_START
    }

    // Connection statistics
    fun updateConnectionTime(duration: Long) {
        _lastConnectionTime.value = duration
        prefs.edit().putLong(KEY_LAST_CONNECTION_TIME, duration).apply()

        val currentTotal = _totalConnectionTime.value ?: 0
        val newTotal = currentTotal + duration
        _totalConnectionTime.value = newTotal
        prefs.edit().putLong(KEY_TOTAL_CONNECTION_TIME, newTotal).apply()
    }

    fun incrementConnectionCount() {
        val currentCount = _connectionCount.value ?: 0
        val newCount = currentCount + 1
        _connectionCount.value = newCount
        prefs.edit().putInt(KEY_CONNECTION_COUNT, newCount).apply()
    }

    fun resetStatistics() {
        _lastConnectionTime.value = 0
        _totalConnectionTime.value = 0
        _connectionCount.value = 0

        prefs.edit()
            .putLong(KEY_LAST_CONNECTION_TIME, 0)
            .putLong(KEY_TOTAL_CONNECTION_TIME, 0)
            .putInt(KEY_CONNECTION_COUNT, 0)
            .apply()
    }

    // DNS server management
    fun setDnsServer(server: String) {
        _dnsServer.value = server
        prefs.edit().putString(KEY_DNS_SERVER, server).apply()
    }

    fun getDnsServer(): String {
        return _dnsServer.value ?: DEFAULT_DNS_SERVER
    }

    // Advanced settings
    fun setBlockUdp53(enabled: Boolean) {
        _blockUdp53.value = enabled
        prefs.edit().putBoolean(KEY_BLOCK_UDP, enabled).apply()
    }

    fun shouldBlockUdp53(): Boolean {
        return _blockUdp53.value ?: DEFAULT_BLOCK_UDP
    }

    // Utility methods
    fun getFormattedConnectionTime(millis: Long): String {
        val seconds = millis / 1000
        val minutes = seconds / 60
        val hours = minutes / 60

        return when {
            hours > 0 -> String.format("%dh %dm", hours, minutes % 60)
            minutes > 0 -> String.format("%dm %ds", minutes, seconds % 60)
            else -> String.format("%ds", seconds)
        }
    }

    fun getFormattedDataSize(bytes: Long): String {
        val kb = bytes / 1024.0
        val mb = kb / 1024.0
        val gb = mb / 1024.0

        return when {
            gb >= 1 -> String.format("%.1f GB", gb)
            mb >= 1 -> String.format("%.1f MB", mb)
            kb >= 1 -> String.format("%.1f KB", kb)
            else -> String.format("%d B", bytes)
        }
    }

    // Export/Import settings
    fun exportSettings(): Map<String, Any> {
        return mapOf(
            KEY_AUTO_START to (_autoStartEnabled.value ?: DEFAULT_AUTO_START),
            KEY_DNS_SERVER to (_dnsServer.value ?: DEFAULT_DNS_SERVER),
            KEY_BLOCK_UDP to (_blockUdp53.value ?: DEFAULT_BLOCK_UDP)
        )
    }

    fun importSettings(settings: Map<String, Any>) {
        settings[KEY_AUTO_START]?.let { setAutoStartEnabled(it as Boolean) }
        settings[KEY_DNS_SERVER]?.let { setDnsServer(it as String) }
        settings[KEY_BLOCK_UDP]?.let { setBlockUdp53(it as Boolean) }
    }
}
