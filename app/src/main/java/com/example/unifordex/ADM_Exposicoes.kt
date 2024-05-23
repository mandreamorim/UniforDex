package com.example.unifordex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unifordex.puxa.Exposicoes
import com.example.unifordex.puxa.MyAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ADM_Exposicoes : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var exposicoesList: ArrayList<Exposicoes>
    private var db = Firebase.firestore

    private lateinit var btnAdd: Button
    private lateinit var btnLogOut: Button
    private lateinit var btnfigurativo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adm_exposicoes)

        btnAdd = findViewById(R.id.btn_ir_para_criar_expo)
        btnLogOut = findViewById(R.id.button_volta_para_adm)
        btnfigurativo = findViewById(R.id.bt_add_obra)

        btnAdd.setOnClickListener {
            val proxima = Intent(this,ADM_Criar_Exposicoes::class.java)
            startActivity(proxima)
        }
        btnLogOut.setOnClickListener {
            val proxima2 = Intent(this,Login_ADM::class.java)
            startActivity(proxima2)
            finish()
        }
        btnfigurativo.setOnClickListener {
            val proxima3 = Intent(this,ADM_Obras::class.java)
            startActivity(proxima3)
            finish()
        }

        recyclerView= findViewById(R.id.recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(this)

        exposicoesList= arrayListOf()

        db= FirebaseFirestore.getInstance()
        db.collection("Exposicoes").get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    for (data in it.documents){
                        Log.d("contentValues", data.toString())
                        exposicoesList.add(Exposicoes(data.get("Nome").toString(),data.get("Ano").toString()))
                    }
                    recyclerView.adapter = MyAdapter(exposicoesList)
                }
            }
            .addOnFailureListener{
                Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
            }

    }
}