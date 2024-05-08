package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ControleAdm : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controle_adm)

        btnAdd = findViewById(R.id.btn_ir_para_criar_expo)
        btnLogOut = findViewById(R.id.button_volta_para_adm)

        btnAdd.setOnClickListener {
            val proxima = Intent(this,CriarExposicao::class.java)
            startActivity(proxima)
        }
        btnLogOut.setOnClickListener {
            val proxima2 = Intent(this,LoginAdm::class.java)
            startActivity(proxima2)
            finish()
        }
    }
}