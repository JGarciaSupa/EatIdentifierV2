package com.lobito.eatidentifiervip.data.service

import android.content.Context
import android.content.Intent

object ForegroundServiceHelper {

    fun startService(context: Context) {
        Intent(context, ForegroundService::class.java).also {
            it.action = ForegroundService.Actions.START.toString()
            context.startService(it)
        }
    }

    fun stopService(context: Context) {
        Intent(context, ForegroundService::class.java).also {
            it.action = ForegroundService.Actions.STOP.toString()
            context.startService(it)
        }
    }
}