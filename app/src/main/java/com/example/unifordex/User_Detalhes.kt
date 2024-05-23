package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class User_Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detalhes)

        val returnButton = findViewById<Button>(R.id.returnButton1)
        returnButton.setOnClickListener {
            val intent = Intent(this@User_Detalhes, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}