package com.auraview.adblocker.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.auraview.adblocker.vpn.AuraViewVpnService
import com.auraview.adblocker.vpn.VpnStateManager

class BootReceiver : BroadcastReceiver() {

    companion object {
        private const val TAG = "BootReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_BOOT_COMPLETED,
            "android.intent.action.QUICKBOOT_POWERON",
            "com.htc.intent.action.QUICKBOOT_POWERON" -> {
                Log.d(TAG, "Device boot completed, checking auto-start setting")

                try {
                    val vpnStateManager = VpnStateManager(context)

                    if (vpnStateManager.isAutoStartEnabled()) {
                        Log.d(TAG, "Auto-start enabled, starting VPN service")

                        // Start the VPN service
                        val vpnIntent = Intent(context, AuraViewVpnService::class.java)
                        context.startService(vpnIntent)

                        Log.d(TAG, "VPN service started on boot")
                    } else {
                        Log.d(TAG, "Auto-start disabled, skipping VPN start")
                    }

                } catch (e: Exception) {
                    Log.e(TAG, "Error starting VPN on boot", e)
                }
            }
            else -> {
                Log.w(TAG, "Unknown intent action: ${intent.action}")
            }
        }
    }
}
