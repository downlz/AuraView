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
import com.auraview.adblocker.vpn.VpnStateManager
import kotlinx.coroutines.launch

class StatisticsFragment : Fragment() {

    private lateinit var backButton: Button
    private lateinit var resetButton: Button

    // Today's stats
    private lateinit var todayBlockedText: TextView
    private lateinit var todayDataText: TextView
    private lateinit var todayQueriesText: TextView

    // Total stats
    private lateinit var totalBlockedText: TextView
    private lateinit var totalDataText: TextView
    private lateinit var totalQueriesText: TextView
    private lateinit var totalTimeText: TextView

    // VPN stats
    private lateinit var vpnConnectionCountText: TextView
    private lateinit var vpnTotalTimeText: TextView

    private lateinit var queryLogger: QueryLogger
    private lateinit var vpnStateManager: VpnStateManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        queryLogger = QueryLogger.getInstance(requireContext())
        vpnStateManager = VpnStateManager(requireContext())

        initializeViews(view)
        setupClickListeners()
        loadStatistics()
    }

    private fun initializeViews(view: View) {
        backButton = view.findViewById(R.id.back_button)
        resetButton = view.findViewById(R.id.reset_button)

        // Today's stats
        todayBlockedText = view.findViewById(R.id.today_blocked_text)
        todayDataText = view.findViewById(R.id.today_data_text)
        todayQueriesText = view.findViewById(R.id.today_queries_text)

        // Total stats
        totalBlockedText = view.findViewById(R.id.total_blocked_text)
        totalDataText = view.findViewById(R.id.total_data_text)
        totalQueriesText = view.findViewById(R.id.total_queries_text)
        totalTimeText = view.findViewById(R.id.total_time_text)

        // VPN stats
        vpnConnectionCountText = view.findViewById(R.id.vpn_connection_count_text)
        vpnTotalTimeText = view.findViewById(R.id.vpn_total_time_text)

        // Set focus for TV navigation
        backButton.requestFocus()
    }

    private fun setupClickListeners() {
        backButton.setOnClickListener {
            (activity as MainActivity).goBack()
        }

        resetButton.setOnClickListener {
            resetStatistics()
        }
    }

    private fun loadStatistics() {
        lifecycleScope.launch {
            try {
                // Load query statistics
                val queryStats = queryLogger.getStatistics()

                // Load VPN statistics
                val vpnConnectionCount = vpnStateManager.connectionCount.value ?: 0
                val vpnTotalTime = vpnStateManager.totalConnectionTime.value ?: 0

                // Update UI on main thread
                activity?.runOnUiThread {
                    updateQueryStatistics(queryStats)
                    updateVpnStatistics(vpnConnectionCount, vpnTotalTime)
                }

            } catch (e: Exception) {
                // Handle error gracefully
                activity?.runOnUiThread {
                    showErrorState()
                }
            }
        }
    }

    private fun updateQueryStatistics(stats: QueryLogger.QueryStatistics) {
        // Today's stats (simplified - would need time-based filtering)
        todayBlockedText.text = stats.blockedQueries.toString()
        todayDataText.text = vpnStateManager.getFormattedDataSize(stats.estimatedDataSaved)
        todayQueriesText.text = stats.totalQueries.toString()

        // Total stats
        totalBlockedText.text = stats.blockedQueries.toString()
        totalDataText.text = vpnStateManager.getFormattedDataSize(stats.estimatedDataSaved)
        totalQueriesText.text = stats.totalQueries.toString()
        totalTimeText.text = vpnStateManager.getFormattedConnectionTime(stats.timeRange)
    }

    private fun updateVpnStatistics(connectionCount: Int, totalTime: Long) {
        vpnConnectionCountText.text = connectionCount.toString()
        vpnTotalTimeText.text = vpnStateManager.getFormattedConnectionTime(totalTime)
    }

    private fun resetStatistics() {
        lifecycleScope.launch {
            try {
                // Reset query statistics
                queryLogger.resetStatistics()

                // Reset VPN statistics
                vpnStateManager.resetStatistics()

                // Reload statistics
                loadStatistics()

                // Show confirmation (in a real app, this would be a dialog)
                activity?.runOnUiThread {
                    // Could show a toast or update a status text
                }

            } catch (e: Exception) {
                // Handle error
                activity?.runOnUiThread {
                    showErrorState()
                }
            }
        }
    }

    private fun showErrorState() {
        // Set all text views to show error or zero values
        val errorText = "0"

        todayBlockedText.text = errorText
        todayDataText.text = "0 B"
        todayQueriesText.text = errorText

        totalBlockedText.text = errorText
        totalDataText.text = "0 B"
        totalQueriesText.text = errorText
        totalTimeText.text = "0s"

        vpnConnectionCountText.text = errorText
        vpnTotalTimeText.text = "0s"
    }

    override fun onResume() {
        super.onResume()
        // Refresh statistics when fragment becomes visible
        loadStatistics()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up if needed
    }
}
