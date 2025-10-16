package com.example.menudepracticas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = findViewById<EditText>(R.id.editTextText)
        val apellidoPaterno = findViewById<EditText>(R.id.editTextText3)
        val apellidoMaterno = findViewById<EditText>(R.id.editTextText4)
        val correo = findViewById<EditText>(R.id.editTextText5)
        val noControl = findViewById<EditText>(R.id.editTextText6)
        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            var nombreText = nombre.text.toString()
            var apPaternoText = apellidoPaterno.text.toString()
            var apMaternoText = apellidoMaterno.text.toString()
            var correoText = correo.text.toString()
            var noControlText = noControl.text.toString()

            if (nombreText.isBlank() || apPaternoText.isBlank() ||
                apMaternoText.isBlank() || correoText.isBlank() ||
                noControlText.isBlank()) {

                Toast.makeText(this, "Falta llenar algún campo", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Datos enviados", Toast.LENGTH_SHORT).show()
                nombre.setText("")
                apellidoPaterno.setText("")
                apellidoMaterno.setText("")
                correo.setText("")
                noControl.setText("")
            }
        }
    }
}