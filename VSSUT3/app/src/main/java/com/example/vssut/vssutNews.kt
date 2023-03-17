package com.example.vssut

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebView
import android.widget.ImageButton

class vssutNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_vssut_news)

        val newsWebView = findViewById<WebView>(R.id.newsWebView)
        newsWebView.loadUrl("https://www.vssut.ac.in/news-events.php")
        val noticeButton = findViewById<ImageButton>(R.id.notices)
        noticeButton.setOnClickListener {
            val intent = Intent(this@vssutNews, MainActivity::class.java)
            startActivity(intent)
        }
        val achievementButton = findViewById<ImageButton>(R.id.achievement)
        achievementButton.setOnClickListener {
            val intent = Intent(this@vssutNews, Achievement::class.java)
            startActivity(intent)
        }
    }
}