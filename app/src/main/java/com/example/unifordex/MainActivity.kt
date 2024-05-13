package com.example.unifordex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isGone
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)



        val textView = findViewById<TextView>(R.id.name)

        val auth = Firebase.auth
        val user = auth.currentUser

        if (user != null) {
            val userName = user.displayName
            textView.text = "Olá, " + userName
        } else {
            // Handle the case where the user is not signed in
        }



// Inside onCreate() method
        val sign_out_button = findViewById<Button>(R.id.logout_button)
        sign_out_button.setOnClickListener {
            signOutAndStartSignInActivity()
        }

        val obraButton = findViewById<Button>(R.id.obraButton)
        obraButton.setOnClickListener {
            val intent = Intent(this@MainActivity, DetalheObra::class.java)
            startActivity(intent)
            finish()
        }

        val scanQR = findViewById<ImageButton>(R.id.scanQR)
        scanQR.setOnClickListener {
            val intent = Intent(this@MainActivity, ScanQR::class.java)
            startActivity(intent)
            finish()
        }

        val exposicoesButton = findViewById<Button>(R.id.exposicoesButton)
        exposicoesButton.setOnClickListener {
            val expoButton = findViewById<Button>(R.id.expoButton)
            if(obraButton.isGone){
                expoButton.visibility = GONE
                obraButton.visibility = VISIBLE
            } else {
                obraButton.visibility = GONE
                expoButton.visibility = VISIBLE
            }
        }

        val conquitas = findViewById<Button>(R.id.conquistasButton)
        conquitas.setOnClickListener {
            val intent = Intent(this, conquistas::class.java)
            startActivity(intent)
        }
    }


    private fun signOutAndStartSignInActivity() {
        mAuth.signOut()

        mGoogleSignInClient.signOut().addOnCompleteListener(this) {
            // Optional: Update UI or show a message to the user
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}