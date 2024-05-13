package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ControleObras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controle_obras)

        val returnButton = findViewById<Button>(R.id.voltar)
        returnButton.setOnClickListener {
            val intent = Intent(this@ControleObras, ControleAdm::class.java)
            startActivity(intent)
            finish()
        }

        val figurativo1 = findViewById<Button>(R.id.figurativo1)
        figurativo1.setOnClickListener {
            val intent = Intent(this@ControleObras, EditarObra::class.java)
            startActivity(intent)
            finish()
        }

        val figurativo = findViewById<Button>(R.id.figurativo)
        figurativo.setOnClickListener {
            val intent = Intent(this@ControleObras, EditarObra::class.java)
            startActivity(intent)
            finish()
        }
    }
}