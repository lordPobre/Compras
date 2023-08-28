package com.example.compras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {

        private lateinit var itemViewModel: ItemViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            // Creando una instancia de ItemAdapter con una instancia de ItemViewModel
            // que a su vez toma una instancia de ItemRepository que necesita una instancia de ItemDao.
            val adapter = ItemAdapter(
                ItemViewModel(
                    ItemRepository(
                        AppDatabase.getDatabase(application).itemDao()
                    )
                )
            )
            recyclerView.adapter = adapter
            // Obtener una instancia de ItemViewModel
            itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
            // Observar los cambios en la lista de items y actualizar la vista en consecuencia.
            itemViewModel.allItems.observe(this, Observer { items: List<Any> ->
                items?.let { adapter.setItems(it) }
            })
            // Observar los cambios en la lista de items y actualizar la vista en consecuencia.
            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                val intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

