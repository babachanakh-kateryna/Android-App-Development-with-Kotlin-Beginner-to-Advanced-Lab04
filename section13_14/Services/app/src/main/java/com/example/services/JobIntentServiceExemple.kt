package com.example.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceExemple: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "JobIntentService started")
        Log.d("Service Thread", Thread.currentThread().name)

    }

    companion object{
        fun myBackgroundService(context: Context, intent: Intent) {
            enqueueWork(context, JobIntentServiceExemple::class.java, 1, intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "JobIntentService destroyed")
    }
}