package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class ClassicServiceExemple: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Service", "Classic Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("Service", "Classic Service started")
        Log.d("Service Thread", Thread.currentThread().name)

//        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "Classic Service destroyed")

    }
}