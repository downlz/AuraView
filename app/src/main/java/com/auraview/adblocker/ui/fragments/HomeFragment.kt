package com.auraview.adblocker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.auraview.adblocker.R
import com.auraview.adblocker.stats.QueryLogger
import com.auraview.adblocker.ui.MainActivity
import com.auraview.adblocker.vpn.VpnController
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var vpnStatusText: TextView
    private lateinit var vpnToggleButton: Button
    private lateinit var adsBlockedText: TextView
    private lateinit var dataSavedText: TextView
    private lateinit var filtersButton: Button
    private lateinit var statsButton: Button
    private lateinit var settingsButton: Button

    private lateinit var vpnController: VpnController
    private lateinit var queryLogger: QueryLogger

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize components
        vpnController = (activity as MainActivity).getVpnController()
        queryLogger = QueryLogger.getInstance(requireContext())

        // Initialize views
        initializeViews(view)

        // Setup click listeners
        setupClickListeners()

        // Update initial state
        vpnController.vpnState.value?.let { updateVpnStatus(it) }
        updateStatistics()
    }

    private fun initializeViews(view: View) {
        vpnStatusText = view.findViewById(R.id.vpn_status_text)
        vpnToggleButton = view.findViewById(R.id.vpn_toggle_button)
        adsBlockedText = view.findViewById(R.id.ads_blocked_text)
        dataSavedText = view.findViewById(R.id.data_saved_text)
        filtersButton = view.findViewById(R.id.filters_button)
        statsButton = view.findViewById(R.id.stats_button)
        settingsButton = view.findViewById(R.id.settings_button)

        // Set focus for TV navigation
        vpnToggleButton.requestFocus()
    }

    private fun setupClickListeners() {
        vpnToggleButton.setOnClickListener {
            toggleVpn()
        }

        filtersButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment("filters")
        }

        statsButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment("stats")
        }

        settingsButton.setOnClickListener {
            (activity as MainActivity).navigateToFragment("settings")
        }
    }

    private fun toggleVpn() {
        if (vpnController.isVpnActive()) {
            (activity as MainActivity).stopVpn()
        } else {
            (activity as MainActivity).startVpn()
        }
    }

    fun updateVpnStatus(state: VpnController.VpnState) {
        activity?.runOnUiThread {
            when (state) {
                VpnController.VpnState.CONNECTED -> {
                    vpnStatusText.text = getString(R.string.vpn_connected)
                    vpnStatusText.setTextColor(resources.getColor(R.color.vpn_active))
                    vpnToggleButton.text = getString(R.string.btn_disable_vpn)
                    vpnToggleButton.isEnabled = true
                }
                VpnController.VpnState.CONNECTING -> {
                    vpnStatusText.text = getString(R.string.vpn_connecting)
                    vpnStatusText.setTextColor(resources.getColor(R.color.vpn_connecting))
                    vpnToggleButton.text = getString(R.string.vpn_connecting)
                    vpnToggleButton.isEnabled = false
                }
                VpnController.VpnState.DISCONNECTING -> {
                    vpnStatusText.text = getString(R.string.vpn_disconnected)
                    vpnStatusText.setTextColor(resources.getColor(R.color.vpn_inactive))
                    vpnToggleButton.text = getString(R.string.btn_disable_vpn)
                    vpnToggleButton.isEnabled = false
                }
                VpnController.VpnState.ERROR -> {
                    vpnStatusText.text = getString(R.string.vpn_error)
                    vpnStatusText.setTextColor(resources.getColor(R.color.error))
                    vpnToggleButton.text = getString(R.string.btn_enable_vpn)
                    vpnToggleButton.isEnabled = true
                }
                else -> { // DISCONNECTED
                    vpnStatusText.text = getString(R.string.vpn_disconnected)
                    vpnStatusText.setTextColor(resources.getColor(R.color.vpn_inactive))
                    vpnToggleButton.text = getString(R.string.btn_enable_vpn)
                    vpnToggleButton.isEnabled = true
                }
            }
        }
    }

    private fun updateStatistics() {
        lifecycleScope.launch {
            try {
                val stats = queryLogger.getStatistics()

                activity?.runOnUiThread {
                    adsBlockedText.text = getString(R.string.ads_blocked, stats.blockedQueries)
                    dataSavedText.text = formatDataSaved(stats.estimatedDataSaved)
                }
            } catch (e: Exception) {
                // Handle error gracefully
                activity?.runOnUiThread {
                    adsBlockedText.text = getString(R.string.ads_blocked, 0)
                    dataSavedText.text = getString(R.string.bandwidth_saved, "0 MB")
                }
            }
        }
    }

    private fun formatDataSaved(bytes: Long): String {
        val kb = bytes / 1024.0
        val mb = kb / 1024.0
        val gb = mb / 1024.0

        return when {
            gb >= 1 -> getString(R.string.bandwidth_saved, String.format("%.1f GB", gb))
            mb >= 1 -> getString(R.string.bandwidth_saved, String.format("%.1f MB", mb))
            kb >= 1 -> getString(R.string.bandwidth_saved, String.format("%.1f KB", kb))
            else -> getString(R.string.bandwidth_saved, String.format("%d B", bytes))
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh statistics when fragment becomes visible
        updateStatistics()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up any observers if needed
    }
}
