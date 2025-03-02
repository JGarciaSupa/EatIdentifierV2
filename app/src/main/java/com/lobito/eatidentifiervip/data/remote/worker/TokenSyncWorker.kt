package com.lobito.eatidentifiervip.data.remote.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.lobito.eatidentifiervip.data.repository.SyncRepositoryImpl

class TokenSyncWorker(
    context: Context,
    params: WorkerParameters,
    private val syncRepositoryImpl: SyncRepositoryImpl
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            Log.i("TokenSyncWorker", "Sincronizando tokens...")
            Result.success()
        } catch (e: Exception) {
            Log.e("TokenSyncWorker", "Error en la sincronización", e)
            Result.retry()
        }
    }
}
