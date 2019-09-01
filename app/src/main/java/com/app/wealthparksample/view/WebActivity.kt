package com.app.wealthparksample.view

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.webkit.WebView

import com.app.wealthparksample.R

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url = intent.extras!!.getString("url")

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(url)
    }
}
