package com.example.compras

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item ORDER BY comprado ASC")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}
