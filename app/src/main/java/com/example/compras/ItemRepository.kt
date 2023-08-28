package com.example.compras


import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {
    // Variable LiveData que contiene la lista de todos los elementos
    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    // Método para insertar un nuevo elemento en la base de datos
    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }
    // Método para insertar un nuevo elemento en la base de datos
    suspend fun update(item: Item) {
        itemDao.update(item)
    }
    // Método para eliminar un elemento de la base de datos
    suspend fun delete(item: Item) {
        itemDao.delete(item)
    }
}
