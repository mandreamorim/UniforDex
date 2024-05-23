package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ADM_Criar_Obras : AppCompatActivity() {

    private lateinit var etNomeObra: EditText
    private lateinit var etCriadorObra: EditText
    private lateinit var etAnoObra: EditText
    private lateinit var etNumObra: EditText
    private lateinit var etImgObra: EditText
    private lateinit var etInfoObra: EditText
    private lateinit var btnSalvarObra: Button

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adm_criar_obras)

        //botoes para salvar---------------------------------------------------
        etNomeObra = findViewById(R.id.add_txt_nome_arte)
        etCriadorObra = findViewById(R.id.add_txt_criador_arte)
        etAnoObra = findViewById(R.id.add_txt_ano_arte)
        etNumObra = findViewById(R.id.add_txt_num_arte)
        etImgObra = findViewById(R.id.add_txt_img_arte)
        etInfoObra = findViewById(R.id.add_txt_inf_arte)
        btnSalvarObra = findViewById(R.id.btn_salvar_dados_arte)

        btnSalvarObra.setOnClickListener{
            val sNome = etNomeObra.text.toString().trim()
            val sCriador = etCriadorObra.text.toString().trim()
            val sAno = etAnoObra.text.toString().trim()
            val sNumero = etNumObra.text.toString().trim()
            val sImg = etImgObra.text.toString().trim()
            val sInfo = etInfoObra.text.toString().trim()

            val userMap = hashMapOf(
                "Nome" to sNome,
                "Criador" to sCriador,
                "Ano" to sAno,
                "Numero" to sNumero,
                "Img" to sImg,
                "Info" to sInfo
            )
            db.collection("Obras").document().set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(this,"Salvo com Sucesso!", Toast.LENGTH_SHORT).show()
                    etNomeObra.text.clear()
                    etCriadorObra.text.clear()
                    etAnoObra.text.clear()
                    etNumObra.text.clear()
                    etImgObra.text.clear()
                    etInfoObra.text.clear()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Falha ao salvar", Toast.LENGTH_SHORT).show()
                }
        }

        val returnButton = findViewById<Button>(R.id.voltar)
        returnButton.setOnClickListener {
            val intent = Intent(this@ADM_Criar_Obras, ADM_Obras::class.java)
            startActivity(intent)
            finish()
        }
    }
}