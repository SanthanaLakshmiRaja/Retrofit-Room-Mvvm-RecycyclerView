package com.example.roomretromvvmrecycle.network

import com.example.roomretromvvmrecycle.model.FoodList
import com.example.roomretromvvmrecycle.Utils.Companion.END_POINT_FILTER
import com.example.roomretromvvmrecycle.database.FoodTable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


    interface MealApi {

        @GET(END_POINT_FILTER)
        fun getFoodsByCategory(@Query("c") categoryName: String): Call<FoodList>
}