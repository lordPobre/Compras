package com.example.compras


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    // Variable LiveData que contiene la lista de todos los elementos
    val allItems: LiveData<List<Item>> = repository.allItems
    // Método que lanza una corrutina para insertar un nuevo elemento en la base de datos
    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item)
    }
    // Método que lanza una corrutina para insertar un nuevo elemento en la base de datos
    fun update(item: Item) = viewModelScope.launch {
        repository.update(item)
    }
    // Método que lanza una corrutina para eliminar un elemento de la base de datos
    fun delete(item: Item) = viewModelScope.launch {
        repository.delete(item)
    }
}
