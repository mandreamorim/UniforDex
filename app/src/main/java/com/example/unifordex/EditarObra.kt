package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditarObra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_obra)

        val returnButton = findViewById<Button>(R.id.voltar)
        returnButton.setOnClickListener {
            val intent = Intent(this@EditarObra, ControleObras::class.java)
            startActivity(intent)
            finish()
        }
    }
}