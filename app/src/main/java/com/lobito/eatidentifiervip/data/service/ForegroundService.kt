package com.lobito.eatidentifiervip.data.service

import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.lobito.eatidentifiervip.R

class ForegroundService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){

        val notification = NotificationCompat.Builder(this, "ForegroundService")
            .setContentTitle("Foreground Service")
            .setContentText("Service is running in the foreground")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        startForeground(1, notification, FOREGROUND_SERVICE_TYPE_DATA_SYNC)
    }


    enum class Actions {
        START,
        STOP
    }

}