package com.example.roomretromvvmrecycle.model

import com.example.roomretromvvmrecycle.database.FoodTable


data class FoodList(

    val meals: List<Food>

)


fun FoodList.asDatabaseModels():List<FoodTable> {
    return meals.map {
        FoodTable(it.id, it.name, it.imageLink)
    }
}