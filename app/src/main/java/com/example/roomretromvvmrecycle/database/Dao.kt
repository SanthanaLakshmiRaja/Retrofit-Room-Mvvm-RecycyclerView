package com.example.roomretromvvmrecycle.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * from food_table")
    fun getfoodList(): LiveData<List<FoodTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(foods:List<FoodTable>)
}