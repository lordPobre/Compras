package com.example.compras

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    // Declara 'id' como la clave primaria y se generará automáticamente
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // Declara 'nombre' como una columna con el nombre "nombre"
    @ColumnInfo(name = "nombre") val nombre: String,
    // Declara 'comprado' como una columna con el nombre "comprado"
    @ColumnInfo(name = "comprado") val comprado: Boolean
)
