package com.example.menudepracticas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNumControl: EditText
    private lateinit var etNombre: EditText
    private lateinit var etCarrera: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias
        etNumControl = findViewById(R.id.etNumControl)
        etNombre = findViewById(R.id.etNombre)
        etCarrera = findViewById(R.id.etCarrera)
        etCorreo = findViewById(R.id.etCorreo)
        btnEnviar = findViewById(R.id.btnEnviar)

        // Validación al dar clic
        btnEnviar.setOnClickListener {
            validarFormulario()
        }
    }

    private fun validarFormulario() {
        val numControl = etNumControl.text.toString().trim()
        val nombre = etNombre.text.toString().trim()
        val carrera = etCarrera.text.toString().trim()
        val correo = etCorreo.text.toString().trim()

        if ( nombre.isEmpty() ) {
            Toast.makeText(this, "⚠️Escribe tu nombre", Toast.LENGTH_SHORT).show()
            return
        }
        if ( carrera.isEmpty() ) {
            Toast.makeText(this, "⚠️Escribe tu carrera", Toast.LENGTH_SHORT).show()
            return
        }
        if (  correo.isEmpty()) {
            Toast.makeText(this, "⚠️Escribe tu correo", Toast.LENGTH_SHORT).show()
            return
        }
        if (numControl.isEmpty()  ){
            Toast.makeText(this, "⚠️ Te falta tu numero de contol", Toast.LENGTH_SHORT).show()
            return
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "⚠️ Correo no válido", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(
            this,
            "Formulario enviado:\n$numControl - $nombre - $carrera - $correo",
            Toast.LENGTH_LONG
        ).show()
    }
}