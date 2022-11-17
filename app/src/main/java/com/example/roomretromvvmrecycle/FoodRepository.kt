package com.example.roomretromvvmrecycle

import android.util.Log
import com.example.roomretromvvmrecycle.database.FoodDatabase
import com.example.roomretromvvmrecycle.model.asDatabaseModels
import com.example.roomretromvvmrecycle.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class FoodRepository(val database: FoodDatabase) {
    val foodLists = database.Dao.getfoodList()

    suspend fun refreshList(){
        withContext(Dispatchers.IO) {
            try{
                val foods = RetrofitInstance.mealApi.getFoodsByCategory("Vegetarian").await()
                database.Dao.insertAll(foods.asDatabaseModels())
            }
            catch (e:Exception)
            {
                Log.e("ERROR",e.message.toString())
            }
        }

    }
}