package com.cesarin26.proyecto

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentAction : AppCompatActivity() {
    lateinit var btn1dial:Button
    lateinit var btn2viewmap:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_action)

        btn1dial=findViewById(R.id.btnIntent1)
        btn2viewmap=findViewById(R.id.btnIntent2)

        btn1dial.setOnClickListener {
            val intent_dial = Intent(ACTION_DIAL, Uri.parse("tel:4451006834"))
            startActivity(intent_dial)
        }
        btn2viewmap.setOnClickListener {
            val intent_view = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com.mx/maps/@20.1416417,-101.1595057,15.2z")
            )
            startActivity(intent_view)
        }
    }
}