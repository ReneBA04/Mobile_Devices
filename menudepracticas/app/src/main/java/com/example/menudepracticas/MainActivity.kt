package com.example.menudepracticas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrSegunda: Button = findViewById(R.id.btnIrSegunda)

        btnIrSegunda.setOnClickListener {
            // Crear un intent para ir a la segunda ventana
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}