package com.example.vssut

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebView
import android.widget.ImageButton

class Achievement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_achievement)
        val AchievementWebView = findViewById<WebView>(R.id.AchievementWebView)
        AchievementWebView.loadUrl("https://www.vssut.ac.in/student-achievements.php")
        val noticesButton = findViewById<ImageButton>(R.id.notices)
        noticesButton.setOnClickListener {
            val intent = Intent(this@Achievement,MainActivity::class.java)
            startActivity(intent)
        }
        val newsButton = findViewById<ImageButton>(R.id.news)
        newsButton.setOnClickListener {
            val intent = Intent(this@Achievement, vssutNews::class.java)
            startActivity(intent)
        }
    }
}