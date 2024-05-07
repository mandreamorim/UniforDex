package com.example.unifordex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalheObra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_obra)

        val returnButton = findViewById<Button>(R.id.returnButton1)
        returnButton.setOnClickListener {
            val intent = Intent(this@DetalheObra, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}