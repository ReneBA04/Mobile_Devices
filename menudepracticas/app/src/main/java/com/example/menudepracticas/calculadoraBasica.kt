package com.example.menudepracticas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var n1: EditText
    lateinit var n2: EditText
    lateinit var btnSumar: Button
    lateinit var btnRestar: Button
    lateinit var btnMultiplicar: Button
    lateinit var btnDividir: Button
    lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        n1 = findViewById(R.id.n1)
        n2 = findViewById(R.id.n2)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        tvResultado = findViewById(R.id.tvResultado)

        // Acción de los botones
        btnSumar.setOnClickListener { suma() }
        btnRestar.setOnClickListener { resta() }
        btnMultiplicar.setOnClickListener { multiplicar() }
        btnDividir.setOnClickListener { dividir() }
    }

    private fun suma() {
        val v1 = n1.text.toString().toDoubleOrNull() ?: 0.0
        val v2 = n2.text.toString().toDoubleOrNull() ?: 0.0
        val res = v1 + v2
        tvResultado.text = "Resultado: $res"
    }

    private fun resta() {
        val v1 = n1.text.toString().toDoubleOrNull() ?: 0.0
        val v2 = n2.text.toString().toDoubleOrNull() ?: 0.0
        val res = v1 - v2
        tvResultado.text = "Resultado: $res"
    }

    private fun multiplicar() {
        val v1 = n1.text.toString().toDoubleOrNull() ?: 0.0
        val v2 = n2.text.toString().toDoubleOrNull() ?: 0.0
        val res = v1 * v2
        tvResultado.text = "Resultado: $res"
    }

    private fun dividir() {
        val v1 = n1.text.toString().toDoubleOrNull() ?: 0.0
        val v2 = n2.text.toString().toDoubleOrNull() ?: 0.0
        val res = if (v2 != 0.0) v1 / v2 else "Error: División entre 0"
        tvResultado.text = "Resultado: $res"
    }

    fun limpiar(view: View) {
        n1.setText("")
        n2.setText("")
        tvResultado.text = ""
    }
}