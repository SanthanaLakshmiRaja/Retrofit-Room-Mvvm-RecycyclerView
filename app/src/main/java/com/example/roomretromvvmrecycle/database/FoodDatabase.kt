package com.example.roomretromvvmrecycle.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FoodTable::class], version = 1, exportSchema = false)
abstract class FoodDatabase: RoomDatabase() {

    abstract  val Dao: Dao

    companion object {

        @Volatile
        private var INSTANCE:FoodDatabase? = null

        @Synchronized
        fun getInstance(context: Context): FoodDatabase{

            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "FavoriteDatabase.db"
                ).build()
                INSTANCE = instance
                return instance

            }

        }

    }


}