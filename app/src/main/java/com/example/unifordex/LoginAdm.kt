package com.example.unifordex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginAdm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_adm)

        val loginAdmButton = findViewById<Button>(R.id.loginAdmButton)
        loginAdmButton.setOnClickListener {
            if(findViewById<EditText>(R.id.passwordInput).text.toString() == "senha"){
                val intent = Intent(this@LoginAdm, ControleAdm::class.java)
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(applicationContext, "Token incorreto", Toast.LENGTH_SHORT).show()
        }

        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@LoginAdm, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}