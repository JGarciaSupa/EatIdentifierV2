package com.lobito.eatidentifiervip.data.remote.worker

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.lobito.eatidentifiervip.di.Qualifiers.*
import java.util.concurrent.TimeUnit

object SyncManager {
    fun scheduleTokenSync(context: Context) {
        Log.i("SyncManager", "scheduleTokenSync")
        val workRequest = PeriodicWorkRequestBuilder<TokenSyncWorker>(1, TimeUnit.HOURS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresBatteryNotLow(false) // Evita que se ejecute si la batería está baja
                    .setRequiresDeviceIdle(false) // Se ejecuta aunque el dispositivo no esté en reposo
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            tokenSyncWorker.toString(),
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}
