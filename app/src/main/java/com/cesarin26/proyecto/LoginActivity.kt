package com.cesarin26.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class LoginActivity: AppCompatActivity(){
    lateinit var btnSingIn:Button
    lateinit var txtUserEmail: TextView
    //Objeto que permitira llamar una actividad que devuelve un resultado
    lateinit var actResultLauncher:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        txtUserEmail=findViewById(R.id.txtUser)

        //staractivityForResult sirve para cuando nuestros activitis nos devolverán algo
        actResultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            //Esto es una interface por lo tanto hay que implementarla
            //Despues de que ejecutes la actividad y se retorne el valor aqui lo podemos atrapar y/o
            //hacer otras cosas, ya que esto se ejecuta justo despues de terminar
            ActivityResultCallback {
                if(it.resultCode== RESULT_OK){
                    val intPar = it.data
                    val userEmail= intPar?.getStringExtra("email")
                    val name=intPar?.getStringExtra("user")
                    Toast.makeText(applicationContext,
                        "email $userEmail",
                    Toast.LENGTH_LONG).show()
                    //Tarea traerme la información al login
                    txtUserEmail.text=userEmail
                }
            })

        btnSingIn=findViewById(R.id.btnSingInLogin)
        btnSingIn.setOnClickListener{
            //Para abrir otra actividad se debe realizar
            //lo siguiente:
            //1.1) Declarar una variable de tipo Intent e inicializarla con la actividad que se abrira
            //val intent_activity_singin = Intent(applicationContext,SiginActivity::class.java)
            //intent_activity_singin.putExtra("parametro", 0)
            //intent_activity_singin.putExtra("otroParametro", "Register")

            //1.2)
            val intent_activity_singin =
                Intent(applicationContext,SiginActivity::class.java).apply {
                    this.putExtra("parametro", 0)
                    this.putExtra("otroParametro", "Register")
                }



            //2)Mandar llamar la actividad con el metodo
            //startActivity(intent_activity_singin)
            actResultLauncher.launch(intent_activity_singin)

        }
    }
}