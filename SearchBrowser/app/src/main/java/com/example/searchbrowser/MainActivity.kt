package com.example.searchbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var webview:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val search=findViewById<EditText>(R.id.search).text
        val webview: WebView = findViewById<WebView>(R.id.web)
        webview.webViewClient = WebViewClient()
        val sb=findViewById<ImageView>(R.id.serchbtn)

        sb.setOnClickListener {
            webview.loadUrl("https://www.google.com/search?q=$search")
            webview.settings.javaScriptEnabled = true
            webview.settings.setSupportZoom(true)
        }

    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webview.canGoBack())
            webview.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}