package com.example.motionlayoutex1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutex1.databinding.ActivityMainBinding
import com.example.motionlayoutex1.model.FoodModel
import com.example.motionlayoutex1.model.foodDummyData

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private lateinit var foodAdapter: FoodAdapter
    private var data = ArrayList<FoodModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        foodAdapter = FoodAdapter(data)
        binding.rvMain.adapter = foodAdapter
        foodAdapter.addAll(foodDummyData)

    }
}