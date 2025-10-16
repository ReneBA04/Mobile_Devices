package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var nombre: EditText //declaracion de variables globales
    lateinit var boton: Button
    lateinit var salida: TextView

    lateinit var n: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nombre = findViewById(R.id.nombre)
        boton = findViewById(R.id.boton)
        salida = findViewById(R.id.salida)

        boton.setOnClickListener {
            n = nombre.getText().toString()
            n = "Hola" + n + "¿cómo estás?"
            salida.setText(n)
        }
    }
}