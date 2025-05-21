package com.campos.erik.laboratoriocalificado02

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.campos.erik.laboratoriocalificado02.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            val nombre = intent.getStringExtra("nombre") ?: ""
            val numero = intent.getStringExtra("numero") ?: ""
            val productos = intent.getStringExtra("productos") ?: ""
            val ciudad = intent.getStringExtra("ciudad") ?: ""
            val direccion = intent.getStringExtra("direccion") ?: ""

            // Mostrar en TextViews
            binding.txtNombre.text = nombre
            binding.txtNumero.text = numero
            binding.txtProductos.text = productos
            binding.txtUbicacion.text = "$ciudad, $direccion"

            binding.btnLlamar.setOnClickListener {
                Toast.makeText(this, "Cliente: $nombre\nTel: $numero\nProductos: $productos\nDirección: $direccion", Toast.LENGTH_LONG).show()
            }

            binding.btnWsp.setOnClickListener {
                Toast.makeText(this, "Hola $nombre. Tus productos: $productos están en camino a la dirección: $direccion", Toast.LENGTH_LONG).show()
            }

            binding.btnMaps.setOnClickListener {
                Toast.makeText(this, "Ubicación: $ciudad, $direccion", Toast.LENGTH_SHORT).show()
            }

        }
    }
}