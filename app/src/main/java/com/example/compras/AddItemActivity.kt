package com.example.compras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class AddItemActivity : AppCompatActivity() {

    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        // Obtener una instancia de ItemViewModel
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        // Establecer un listener para el botón
        button.setOnClickListener {
            val nombre = editText.text.toString()
            // Compruebe si el EditText no está vacío
            if (nombre.isNotEmpty()) {
                // Crear un nuevo item y guardarlo en la base de datos
                val item = Item(nombre = nombre, comprado = false)
                itemViewModel.insert(item)
                finish()
            } else {
                // Mostrar un mensaje de error o hacer algo cuando el EditText esté vacío
            }
        }
    }
}

