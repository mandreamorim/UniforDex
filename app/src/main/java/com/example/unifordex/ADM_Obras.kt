package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ADM_Obras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adm_obras)

        val returnButton = findViewById<Button>(R.id.voltar)
        returnButton.setOnClickListener {
            val intent = Intent(this@ADM_Obras, ADM_Exposicoes::class.java)
            startActivity(intent)
            finish()
        }

        val figurativo = findViewById<Button>(R.id.bt_add_obra)
        figurativo.setOnClickListener {
            val intent = Intent(this@ADM_Obras, ADM_Criar_Obras::class.java)
            startActivity(intent)
            finish()
        }
    }
}