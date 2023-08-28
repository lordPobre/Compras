package com.example.compras


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Método para obtener la instancia de la base de datos
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            // Si ya hay una instancia, la retorna
            if (tempInstance != null) {
                return tempInstance
            }
            // Bloque sincronizado para evitar que múltiples hilos creen múltiples instancias de la base de datos
            synchronized(this) {
                // Crea una nueva instancia de la base de datos
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
