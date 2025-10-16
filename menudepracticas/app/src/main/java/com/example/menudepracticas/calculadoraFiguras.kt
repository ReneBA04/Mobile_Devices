package com.example.menudepracticas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.calculadorafiguras.R

class MainActivity : AppCompatActivity() {

    private lateinit var etBase: EditText
    private lateinit var etAltura: EditText
    private lateinit var rgFiguras: RadioGroup
    private lateinit var rbTriangulo: RadioButton
    private lateinit var rbCuadrado: RadioButton
    private lateinit var rbRectangulo: RadioButton
    private lateinit var rbCirculo: RadioButton
    private lateinit var btnMostrar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBase = findViewById(R.id.etBase)
        etAltura = findViewById(R.id.etAltura)
        rgFiguras = findViewById(R.id.rgFiguras)
        rbTriangulo = findViewById(R.id.rbTriangulo)
        rbCuadrado = findViewById(R.id.rbCuadrado)
        rbRectangulo = findViewById(R.id.rbRectangulo)
        rbCirculo = findViewById(R.id.rbCirculo)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        tvResultado = findViewById(R.id.tvResultado)

        // Botón Mostrar
        btnMostrar.setOnClickListener {
            calcularArea()
        }

        // Botón Limpiar
        btnLimpiar.setOnClickListener {
            etBase.text.clear()
            etAltura.text.clear()
            rgFiguras.clearCheck()
            tvResultado.text = "Área: "
        }
    }

    private fun calcularArea() {
        val baseStr = etBase.text.toString().trim()
        val alturaStr = etAltura.text.toString().trim()

        // Validación campos vacíos
        if (baseStr.isEmpty() && !rbCirculo.isChecked) {
            Toast.makeText(this, "Ingrese la base", Toast.LENGTH_SHORT).show()
            return
        }
        if (alturaStr.isEmpty() && !rbCirculo.isChecked && !rbCuadrado.isChecked) {
            Toast.makeText(this, "Ingrese la altura", Toast.LENGTH_SHORT).show()
            return
        }

        val base = if (baseStr.isEmpty()) 0.0 else baseStr.toDouble()
        val altura = if (alturaStr.isEmpty()) 0.0 else alturaStr.toDouble()
        var area = 0.0

        when {
            rbTriangulo.isChecked -> area = (base * altura) / 2
            rbCuadrado.isChecked -> area = base * base
            rbRectangulo.isChecked -> area = base * altura
            rbCirculo.isChecked -> area = Math.PI * Math.pow(base, 2.0) // base = radio
            else -> {
                Toast.makeText(this, "Seleccione una figura", Toast.LENGTH_SHORT).show()
                return
            }
        }

        tvResultado.text = "Área: $area"
    }
}
