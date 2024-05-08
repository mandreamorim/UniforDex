package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CriarExposicao : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etAno: EditText
    private lateinit var btnSalvar: Button
    private lateinit var btnVolta: Button

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_criar_exposicao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Botao para salvar os dados--------------------------------------------------------------------------------------------------
        etNome = findViewById(R.id.add_txt_nome)
        etAno = findViewById(R.id.add_txt_ano)
        btnSalvar = findViewById(R.id.btn_salvar_dados_expo)

        btnSalvar.setOnClickListener{
            val sNome = etNome.text.toString().trim()
            val sAno = etAno.text.toString().trim()

            val userMap = hashMapOf(
                "Nome" to sNome,
                "Ano" to sAno
            )

            db.collection("Exposicoes").document().set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(this,"Salvo com Sucesso!", Toast.LENGTH_SHORT).show()
                    etNome.text.clear()
                    etAno.text.clear()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Falha ao salvar", Toast.LENGTH_SHORT).show()
                }
        }

        //Botao para voltar----------------------------------------------------------------------------------------------------------------
        btnVolta = findViewById(R.id.btn_ir_para_adm_expo)
        btnVolta.setOnClickListener {
            Irpara()
        }

    }

    private fun Irpara(){
        val voltar = Intent(this,ControleAdm::class.java)
        startActivity(voltar)
    }

}