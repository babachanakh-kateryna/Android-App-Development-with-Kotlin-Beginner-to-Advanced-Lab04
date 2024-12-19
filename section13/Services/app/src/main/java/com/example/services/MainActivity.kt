package com.example.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var startClassService: Button
    lateinit var startIntentService: Button
    lateinit var stopService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startClassService = findViewById(R.id.startClassicService)
        startIntentService = findViewById(R.id.startJobIntent)
        stopService = findViewById(R.id.stopService)

        startClassService.setOnClickListener {
            val intent = Intent(this@MainActivity, ClassicServiceExemple::class.java)
            startService(intent)
        }

        startIntentService.setOnClickListener {
            val intent = Intent(this@MainActivity, JobIntentServiceExemple::class.java)
            JobIntentServiceExemple.myBackgroundService(this@MainActivity, intent)
        }

        stopService.setOnClickListener {
            val intent = Intent(this@MainActivity, ClassicServiceExemple::class.java)
            stopService(intent)
        }
    }
}