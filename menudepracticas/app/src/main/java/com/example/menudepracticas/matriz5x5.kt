package com.example.menudepracticas

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayout: GridLayout
    private val rowCount = 5
    private val columnCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridLayout = findViewById(R.id.gridLayout)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        val btnRegenerar = findViewById<Button>(R.id.btnRegenerar)

        // Generamos números al inicio
        generarNumeros()

        // Limpiar la cuadrícula
        btnLimpiar.setOnClickListener {
            gridLayout.removeAllViews()
        }

        // Re-generar números
        btnRegenerar.setOnClickListener {
            gridLayout.removeAllViews()
            generarNumeros()
        }
    }

    private fun generarNumeros() {
        for (i in 0 until rowCount * columnCount) {
            val number = Random.nextInt(0, 101)
            val button = Button(this)
            button.text = number.toString()

            button.setOnClickListener {
                Toast.makeText(this, "Número: $number", Toast.LENGTH_SHORT).show()
            }

            val params = GridLayout.LayoutParams().apply {
                width = 0
                height = GridLayout.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                setMargins(8, 8, 8, 8)
            }
            button.layoutParams = params

            gridLayout.addView(button)
        }
    }
}