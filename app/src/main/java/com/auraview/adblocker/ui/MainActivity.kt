package com.auraview.adblocker.ui

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.auraview.adblocker.R
import com.auraview.adblocker.filter.FilterUpdateManager
import com.auraview.adblocker.ui.fragments.FilterManagementFragment
import com.auraview.adblocker.ui.fragments.HomeFragment
import com.auraview.adblocker.ui.fragments.SettingsFragment
import com.auraview.adblocker.ui.fragments.StatisticsFragment
import com.auraview.adblocker.vpn.VpnController
import kotlinx.coroutines.launch

class MainActivity : FragmentActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val REQUEST_VPN_PERMISSION = 100
    }

    private lateinit var vpnController: VpnController
    private lateinit var filterUpdateManager: FilterUpdateManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity created")

        // Initialize components
        vpnController = VpnController.getInstance(this)
        filterUpdateManager = FilterUpdateManager(this)

        // Load cached filters on startup
        lifecycleScope.launch {
            filterUpdateManager.loadCachedFilters()
        }

        // Setup initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, HomeFragment())
                .commit()
        }

        // Observe VPN state changes
        observeVpnState()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_VPN_PERMISSION -> {
                if (resultCode == Activity.RESULT_OK) {
                    // VPN permission granted, start VPN
                    lifecycleScope.launch {
                        vpnController.startVpn()
                    }
                } else {
                    // VPN permission denied
                    Log.w(TAG, "VPN permission denied by user")
                    showVpnPermissionError()
                }
            }
        }
    }

    /**
     * Request VPN permission from user
     */
    fun requestVpnPermission() {
        val vpnIntent = vpnController.getVpnPermissionIntent()
        if (vpnIntent != null) {
            startActivityForResult(vpnIntent, REQUEST_VPN_PERMISSION)
        } else {
            // Permission already granted, start VPN directly
            lifecycleScope.launch {
                vpnController.startVpn()
            }
        }
    }

    /**
     * Start VPN service
     */
    fun startVpn() {
        lifecycleScope.launch {
            val success = vpnController.startVpn()
            if (!success) {
                // Need permission first
                requestVpnPermission()
            }
        }
    }

    /**
     * Stop VPN service
     */
    fun stopVpn() {
        vpnController.stopVpn()
    }

    /**
     * Get VPN controller instance
     */
    fun getVpnController(): VpnController = vpnController

    /**
     * Get filter update manager instance
     */
    fun getFilterUpdateManager(): FilterUpdateManager = filterUpdateManager

    /**
     * Navigate to a specific fragment
     */
    fun navigateToFragment(fragmentTag: String) {
        val fragment = when (fragmentTag) {
            "home" -> HomeFragment()
            "filters" -> FilterManagementFragment()
            "stats" -> StatisticsFragment()
            "settings" -> SettingsFragment()
            else -> HomeFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragmentTag)
            .commit()
    }

    /**
     * Go back to previous fragment
     */
    fun goBack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            // If no back stack, go to home
            navigateToFragment("home")
        }
    }

    private fun observeVpnState() {
        vpnController.vpnState.observe(this) { state ->
            state?.let {
                Log.d(TAG, "VPN state changed: $it")
                // Update UI based on VPN state
                updateVpnStatusDisplay(it)
            }
        }
    }

    private fun updateVpnStatusDisplay(state: VpnController.VpnState) {
        // This will be called by fragments to update their UI
        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_container)
        when (currentFragment) {
            is HomeFragment -> currentFragment.updateVpnStatus(state)
            is FilterManagementFragment -> currentFragment.updateVpnStatus(state)
            // Add other fragments as needed
        }
    }

    private fun showVpnPermissionError() {
        // Show error message to user
        Log.e(TAG, "VPN permission required for ad blocking functionality")
        // In a real implementation, show a dialog or toast
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity destroyed")
    }
}
