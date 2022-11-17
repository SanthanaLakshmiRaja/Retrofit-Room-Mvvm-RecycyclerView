package com.example.roomretromvvmrecycle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomretromvvmrecycle.database.FoodDatabase.Companion.getInstance
import com.example.roomretromvvmrecycle.database.FoodTable
import com.example.roomretromvvmrecycle.model.FoodList
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class HomeViewModel (application: Application): AndroidViewModel(application) {
    val database = getInstance(application)
    private val repository=FoodRepository(database)

    var foods:LiveData<List<FoodTable>> = repository.foodLists


    init {
        //refreshList()
        viewModelScope.launch {
            repository.refreshList()
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun observeFoods(): LiveData<List<FoodTable>> {
        return foods
    }

}