package com.campos.erik.laboratoriocalificado02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            binding.btnRegistrar.setOnClickListener {
                val nombre = binding.txtNombre.text.toString()
                val numero = binding.txtNumero.text.toString()
                val productos = binding.txtProductos.text.toString()
                val ciudad = binding.txtCiudad.text.toString()
                val direccion = binding.txtDireccion.text.toString()

                if (nombre.isBlank() || numero.isBlank() || productos.isBlank() || ciudad.isBlank() || direccion.isBlank()) {
                    Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this, DetallePedidoActivity::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("numero", numero)
                    putExtra("productos", productos)
                    putExtra("ciudad", ciudad)
                    putExtra("direccion", direccion)
                }
                startActivity(intent)
            }

        }

    }
}