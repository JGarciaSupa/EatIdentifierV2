package com.lobito.eatidentifiervip

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import com.lobito.eatidentifiervip.data.remote.worker.SyncManager
import com.lobito.eatidentifiervip.di.*
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
//            workManagerFactory()
            modules(networkModule,appModule, dataModule,viewModule,serviceModule,useCaseModule )
        }
        notification()
    }

//    private fun wokerManagerFuncion(context : Context){
//        SyncManager.scheduleTokenSync(context)
//    }

    @SuppressLint("SuspiciousIndentation")
    private fun notification(){
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                 "ForegroundService",
                 "Runnin Notifications",
                    NotificationManager.IMPORTANCE_HIGH
            )
         val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}