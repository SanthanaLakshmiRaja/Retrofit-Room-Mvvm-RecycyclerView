package com.example.roomretromvvmrecycle.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.roomretromvvmrecycle.R
import com.example.roomretromvvmrecycle.database.FoodTable
import com.example.roomretromvvmrecycle.databinding.ItemListBinding
import com.example.roomretromvvmrecycle.model.Food

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyHomeViewHolder>() {

    private var foods: List<FoodTable> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeViewHolder {
        return MyHomeViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(myHomeViewHolder: MyHomeViewHolder, position: Int) {

        val food = foods[position]

        myHomeViewHolder.binding.apply {

            mImageView.load(food.imageLink) {
                placeholder(R.color.purple_200)
                error(R.color.purple_200)

            }
            mTextViewName.text = food.name

        }



    }

    override fun getItemCount(): Int {
        return foods.size
    }

    class MyHomeViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root)

    fun setFoods(foods: List<FoodTable>) {
        this.foods = foods
        notifyDataSetChanged()
    }




}

