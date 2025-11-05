package com.auraview.adblocker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auraview.adblocker.R
import com.auraview.adblocker.filter.FilterUpdateManager
import com.auraview.adblocker.ui.MainActivity
import com.auraview.adblocker.vpn.VpnController
import kotlinx.coroutines.launch

class FilterManagementFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var updateAllButton: Button
    private lateinit var backButton: Button
    private lateinit var lastUpdateText: TextView

    private lateinit var filterUpdateManager: FilterUpdateManager
    private lateinit var adapter: FilterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterUpdateManager = (activity as MainActivity).getFilterUpdateManager()

        initializeViews(view)
        setupRecyclerView()
        setupClickListeners()
        loadFilterData()
    }

    private fun initializeViews(view: View) {
        recyclerView = view.findViewById(R.id.filter_recycler_view)
        updateAllButton = view.findViewById(R.id.update_all_button)
        backButton = view.findViewById(R.id.back_button)
        lastUpdateText = view.findViewById(R.id.last_update_text)

        // Set focus for TV navigation
        backButton.requestFocus()
    }

    private fun setupRecyclerView() {
        adapter = FilterListAdapter { filterName, enabled ->
            // Handle filter toggle
            // This would update the filter state in the filter engine
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun setupClickListeners() {
        backButton.setOnClickListener {
            (activity as MainActivity).goBack()
        }

        updateAllButton.setOnClickListener {
            updateAllFilters()
        }
    }

    private fun loadFilterData() {
        lifecycleScope.launch {
            val metadata = filterUpdateManager.getFilterMetadata()
            val filterItems = createFilterItems(metadata)
            adapter.updateFilters(filterItems)

            updateLastUpdateText(metadata)
        }
    }

    private fun createFilterItems(metadata: Map<String, FilterUpdateManager.FilterMetadata>): List<FilterItem> {
        return FilterUpdateManager.DEFAULT_FILTER_LISTS.map { (name, url) ->
            val meta = metadata[name]
            FilterItem(
                name = name,
                displayName = getFilterDisplayName(name),
                ruleCount = meta?.ruleCount ?: 0,
                lastUpdate = meta?.lastUpdate ?: 0,
                isEnabled = true // This would be loaded from preferences
            )
        }
    }

    private fun getFilterDisplayName(filterName: String): String {
        return when (filterName) {
            "ublock-filters" -> getString(R.string.filter_ubase)
            "ublock-privacy" -> getString(R.string.filter_privacy)
            "ublock-malware" -> getString(R.string.filter_malware)
            "ublock-annoyances" -> getString(R.string.filter_annoyances)
            "ublock-mobile" -> getString(R.string.filter_mobile)
            else -> filterName
        }
    }

    private fun updateAllFilters() {
        lifecycleScope.launch {
            updateAllButton.isEnabled = false
            updateAllButton.text = getString(R.string.msg_filters_updating)

            try {
                val results = filterUpdateManager.updateAllFilters()

                val successCount = results.values.count { it }
                val totalCount = results.size

                if (successCount == totalCount) {
                    updateAllButton.text = getString(R.string.msg_filters_updated)
                } else {
                    updateAllButton.text = getString(R.string.msg_filters_update_failed)
                }

                // Reload filter data
                loadFilterData()

            } catch (e: Exception) {
                updateAllButton.text = getString(R.string.msg_filters_update_failed)
            } finally {
                updateAllButton.isEnabled = true
            }
        }
    }

    private fun updateLastUpdateText(metadata: Map<String, FilterUpdateManager.FilterMetadata>) {
        val latestUpdate = metadata.values.maxOfOrNull { it.lastUpdate } ?: 0L

        if (latestUpdate > 0) {
            val timeAgo = getTimeAgo(latestUpdate)
            lastUpdateText.text = getString(R.string.msg_filters_updated, timeAgo)
        } else {
            lastUpdateText.text = getString(R.string.msg_filters_update_failed)
        }
    }

    private fun getTimeAgo(timestamp: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timestamp

        val minutes = diff / (1000 * 60)
        val hours = diff / (1000 * 60 * 60)
        val days = diff / (1000 * 60 * 60 * 24)

        return when {
            minutes < 60 -> getString(R.string.stats_today) // Less than 1 hour
            hours < 24 -> getString(R.string.stats_today) // Today
            days == 1L -> "1 day ago"
            days < 7 -> "$days days ago"
            else -> "1 week ago"
        }
    }

    fun updateVpnStatus(state: VpnController.VpnState) {
        // Update UI based on VPN state if needed
        // For example, disable update buttons when VPN is active
    }

    // Data class for filter items
    data class FilterItem(
        val name: String,
        val displayName: String,
        val ruleCount: Int,
        val lastUpdate: Long,
        val isEnabled: Boolean
    )

    // RecyclerView Adapter
    inner class FilterListAdapter(
        private val onFilterToggle: (String, Boolean) -> Unit
    ) : RecyclerView.Adapter<FilterListAdapter.FilterViewHolder>() {

        private var filters = listOf<FilterItem>()

        fun updateFilters(newFilters: List<FilterItem>) {
            filters = newFilters
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter, parent, false)
            return FilterViewHolder(view)
        }

        override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
            holder.bind(filters[position])
        }

        override fun getItemCount(): Int = filters.size

        inner class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val nameText: TextView = itemView.findViewById(R.id.filter_name)
            private val ruleCountText: TextView = itemView.findViewById(R.id.rule_count)
            private val toggleButton: Button = itemView.findViewById(R.id.toggle_button)

            fun bind(filter: FilterItem) {
                nameText.text = filter.displayName
                ruleCountText.text = getString(R.string.filter_rule_count, filter.ruleCount)

                toggleButton.text = if (filter.isEnabled) "Enabled" else "Disabled"
                toggleButton.setOnClickListener {
                    onFilterToggle(filter.name, !filter.isEnabled)
                }
            }
        }
    }
}
