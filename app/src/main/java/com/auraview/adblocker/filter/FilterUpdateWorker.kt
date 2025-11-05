package com.auraview.adblocker.filter

import android.content.Context
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.runBlocking

class FilterUpdateWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    companion object {
        private const val TAG = "FilterUpdateWorker"
        const val WORK_NAME = "filter_update_work"

        fun schedule(context: Context, intervalHours: Int = 24) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

            val updateWork = PeriodicWorkRequestBuilder<FilterUpdateWorker>(
                intervalHours.toLong(), java.util.concurrent.TimeUnit.HOURS
            )
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.EXPONENTIAL,
                    30, java.util.concurrent.TimeUnit.MINUTES
                )
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.UPDATE,
                updateWork
            )

            Log.d(TAG, "Scheduled periodic filter updates every $intervalHours hours")
        }

        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
            Log.d(TAG, "Cancelled periodic filter updates")
        }
    }

    override suspend fun doWork(): Result {
        Log.d(TAG, "Starting background filter update")

        return try {
            val filterUpdateManager = FilterUpdateManager(applicationContext)

            // Update all filters
            val results = filterUpdateManager.updateAllFilters()

            // Check results
            val successCount = results.values.count { it }
            val totalCount = results.size

            Log.d(TAG, "Filter update completed: $successCount/$totalCount successful")

            if (successCount > 0) {
                // At least some updates succeeded
                Result.success()
            } else {
                // All updates failed - retry later
                Log.w(TAG, "All filter updates failed, will retry")
                Result.retry()
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error during filter update", e)

            // Check if this is a network error (retry) or a more serious error (fail)
            if (isNetworkError(e)) {
                Log.w(TAG, "Network error during filter update, will retry")
                Result.retry()
            } else {
                Log.e(TAG, "Non-network error during filter update, failing")
                Result.failure()
            }
        }
    }

    private fun isNetworkError(exception: Exception): Boolean {
        val message = exception.message?.lowercase() ?: ""
        return message.contains("network") ||
               message.contains("timeout") ||
               message.contains("connection") ||
               message.contains("unreachable") ||
               message.contains("unknown host")
    }
}
