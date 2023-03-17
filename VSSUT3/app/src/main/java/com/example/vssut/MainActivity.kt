package com.example.vssut

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebView
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://www.vssut.ac.in/notice-board.php")
        val newsButton = findViewById<ImageButton>(R.id.news)
        newsButton.setOnClickListener {
            newsButton()
        }
        val achievementButton = findViewById<ImageButton>(R.id.achievement)
        achievementButton.setOnClickListener {
            val intent = Intent(this@MainActivity, Achievement::class.java)
            startActivity(intent)
        }
    }

    fun newsButton(){
        val intent = Intent(this@MainActivity,vssutNews::class.java)
        startActivity(intent)
    }

}