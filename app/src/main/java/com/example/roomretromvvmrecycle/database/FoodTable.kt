package com.example.roomretromvvmrecycle.database

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "food_table")
    data class FoodTable(

        @PrimaryKey
        val id: String,

        val name: String?,

        val imageLink: String?

    )

