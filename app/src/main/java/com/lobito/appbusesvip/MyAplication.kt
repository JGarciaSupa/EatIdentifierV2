package com.lobito.appbusesvip

import android.app.Application
import android.content.Context
import android.util.Log
import com.lobito.appbusesvip.data.remote.worker.SyncManager
import com.lobito.appbusesvip.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MyApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            workManagerFactory()
            modules(networkModule,appModule, dataModule,viewModule,serviceModule,useCaseModule )
        }

        wokerManagerFuncion(this)
    }

    private fun wokerManagerFuncion(context : Context){
        Log.i("SyncManager", "wokerManagerFuncion")
        SyncManager.scheduleTokenSync(context)
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}