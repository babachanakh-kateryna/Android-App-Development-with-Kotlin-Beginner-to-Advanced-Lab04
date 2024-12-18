package com.example.scroollwebviews

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView = findViewById(R.id.web)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")

        onBackPressedDispatcher.addCallback(this, callback)
    }

    val callback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            if(webView.canGoBack()){
                webView.goBack()
            }else{
                finish()
            }
        }

    }
}