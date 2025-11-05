package com.auraview.adblocker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.auraview.adblocker.R
import com.auraview.adblocker.ui.MainActivity
import com.auraview.adblocker.vpn.VpnController
import com.auraview.adblocker.vpn.VpnStateManager

class SettingsFragment : Fragment() {

    private lateinit var backButton: Button
    private lateinit var saveButton: Button

    // Settings switches
    private lateinit var autoStartSwitch: Switch
    private lateinit var blockUdpSwitch: Switch

    // DNS settings
    private lateinit var dnsServerText: TextView
    private lateinit var dnsCloudflareButton: Button
    private lateinit var dnsGoogleButton: Button
    private lateinit var dnsQuad9Button: Button

    // Update settings
    private lateinit var updateFrequencyText: TextView
    private lateinit var updateDailyButton: Button
    private lateinit var updateWeeklyButton: Button

    private lateinit var vpnStateManager: VpnStateManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vpnStateManager = VpnStateManager(requireContext())

        initializeViews(view)
        setupClickListeners()
        loadCurrentSettings()
    }

    private fun initializeViews(view: View) {
        backButton = view.findViewById(R.id.back_button)
        saveButton = view.findViewById(R.id.save_button)

        // Settings switches
        autoStartSwitch = view.findViewById(R.id.auto_start_switch)
        blockUdpSwitch = view.findViewById(R.id.block_udp_switch)

        // DNS settings
        dnsServerText = view.findViewById(R.id.dns_server_text)
        dnsCloudflareButton = view.findViewById(R.id.dns_cloudflare_button)
        dnsGoogleButton = view.findViewById(R.id.dns_google_button)
        dnsQuad9Button = view.findViewById(R.id.dns_quad9_button)

        // Update settings
        updateFrequencyText = view.findViewById(R.id.update_frequency_text)
        updateDailyButton = view.findViewById(R.id.update_daily_button)
        updateWeeklyButton = view.findViewById(R.id.update_weekly_button)

        // Set focus for TV navigation
        backButton.requestFocus()
    }

    private fun setupClickListeners() {
        backButton.setOnClickListener {
            (activity as MainActivity).goBack()
        }

        saveButton.setOnClickListener {
            saveSettings()
        }

        // DNS server buttons
        dnsCloudflareButton.setOnClickListener {
            selectDnsServer("1.1.1.1")
        }

        dnsGoogleButton.setOnClickListener {
            selectDnsServer("8.8.8.8")
        }

        dnsQuad9Button.setOnClickListener {
            selectDnsServer("9.9.9.9")
        }

        // Update frequency buttons
        updateDailyButton.setOnClickListener {
            selectUpdateFrequency("daily")
        }

        updateWeeklyButton.setOnClickListener {
            selectUpdateFrequency("weekly")
        }
    }

    private fun loadCurrentSettings() {
        // Load auto-start setting
        autoStartSwitch.isChecked = vpnStateManager.isAutoStartEnabled()

        // Load UDP blocking setting
        blockUdpSwitch.isChecked = vpnStateManager.shouldBlockUdp53()

        // Load DNS server setting
        val currentDns = vpnStateManager.getDnsServer()
        dnsServerText.text = getDnsServerDisplayName(currentDns)
        updateDnsButtonStates(currentDns)

        // Load update frequency (placeholder - would be stored in preferences)
        updateFrequencyText.text = getString(R.string.setting_update_daily)
        updateDailyButton.isSelected = true
        updateWeeklyButton.isSelected = false
    }

    private fun selectDnsServer(server: String) {
        dnsServerText.text = getDnsServerDisplayName(server)
        updateDnsButtonStates(server)
    }

    private fun getDnsServerDisplayName(server: String): String {
        return when (server) {
            "1.1.1.1" -> getString(R.string.setting_dns_cloudflare)
            "8.8.8.8" -> getString(R.string.setting_dns_google)
            "9.9.9.9" -> getString(R.string.setting_dns_quad9)
            else -> server
        }
    }

    private fun updateDnsButtonStates(selectedServer: String) {
        dnsCloudflareButton.isSelected = selectedServer == "1.1.1.1"
        dnsGoogleButton.isSelected = selectedServer == "8.8.8.8"
        dnsQuad9Button.isSelected = selectedServer == "9.9.9.9"
    }

    private fun selectUpdateFrequency(frequency: String) {
        updateFrequencyText.text = when (frequency) {
            "daily" -> getString(R.string.setting_update_daily)
            "weekly" -> getString(R.string.setting_update_weekly)
            else -> getString(R.string.setting_update_daily)
        }

        updateDailyButton.isSelected = frequency == "daily"
        updateWeeklyButton.isSelected = frequency == "weekly"
    }

    private fun saveSettings() {
        try {
            // Save auto-start setting
            vpnStateManager.setAutoStartEnabled(autoStartSwitch.isChecked)

            // Save UDP blocking setting
            vpnStateManager.setBlockUdp53(blockUdpSwitch.isChecked)

            // Save DNS server setting
            val selectedDnsServer = when {
                dnsCloudflareButton.isSelected -> "1.1.1.1"
                dnsGoogleButton.isSelected -> "8.8.8.8"
                dnsQuad9Button.isSelected -> "9.9.9.9"
                else -> "8.8.8.8" // Default
            }
            vpnStateManager.setDnsServer(selectedDnsServer)

            // Save update frequency (placeholder - would save to preferences)
            // This would be implemented with SharedPreferences

            // Show success feedback (in a real app, this would be a toast or dialog)
            activity?.runOnUiThread {
                // Could show a "Settings saved" message
            }

        } catch (e: Exception) {
            // Handle save error
            activity?.runOnUiThread {
                // Could show an error message
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up if needed
    }
}
