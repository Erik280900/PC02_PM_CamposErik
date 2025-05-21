package com.campos.erik.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.campos.erik.laboratoriocalificado02.databinding.ActivityEjercicio01Binding
import com.campos.erik.laboratoriocalificado02.databinding.ActivityMainBinding

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)

        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val arrayListBtn = arrayListOf(binding.btnMostrar, binding.btnOcultar)

        setContentView(binding.root)

        arrayListBtn.forEach { button ->
            button.setOnClickListener {
                Toast.makeText(this, "Haz pulsado el botón ${button.text}", Toast.LENGTH_SHORT).show()

                when (button.id) {
                    R.id.btnMostrar -> binding.viewVerde.visibility = View.VISIBLE
                    R.id.btnOcultar -> binding.viewVerde.visibility = View.GONE
                }
            }
    }
}
}