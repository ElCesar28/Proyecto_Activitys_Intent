package com.cesarin26.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SiginActivity : AppCompatActivity() {

    lateinit var txtN:EditText
    lateinit var txtE:EditText
    lateinit var btnSave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigin)
        //Recuperación de parametros del intent
        val titulo = intent.getStringExtra("otroParametro")
        val entero = intent.getIntExtra("parametro",-1)

        title= titulo.toString()
        Toast.makeText(applicationContext,"Accion: $entero",Toast.LENGTH_LONG).show()

        txtN=findViewById(R.id.txtName)
        txtE=findViewById(R.id.txtEmail)
        btnSave=findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val intentRsult= Intent()
            intentRsult.putExtra("email",txtE.text.toString())
            intentRsult.putExtra("user",txtN.text.toString())
            setResult(RESULT_OK,intentRsult)
            finish()
        }
    }
}