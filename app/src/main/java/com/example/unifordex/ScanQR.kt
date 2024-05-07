package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScanQR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qr)

        val returnButton = findViewById<Button>(R.id.returnButton2)
        returnButton.setOnClickListener {
            val intent = Intent(this@ScanQR, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}