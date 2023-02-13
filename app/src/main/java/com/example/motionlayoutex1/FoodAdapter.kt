package com.example.motionlayoutex1

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutex1.databinding.ItemFoodBinding
import com.example.motionlayoutex1.model.FoodModel
import com.example.motionlayoutex1.model.MoreImageModel
import com.example.motionlayoutex1.model.imageDummyData
import com.example.motionlayoutex1.utils.LinearItemDecoration

class FoodAdapter(private var mList: ArrayList<FoodModel>?) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private lateinit var imageAdapter: ImageAdapter
    private var imageData = ArrayList<MoreImageModel>()


    class ViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList!![position]) {
                binding.ivFood.setImageResource(imgId)
                binding.tvTitle.text = this.title
                binding.tvDescription.text = this.description
                binding.tvCalories.text = this.calories
                binding.tvRate.text = this.rate

                binding.morePic.layoutManager =
                    LinearLayoutManager(binding.morePic.context, RecyclerView.HORIZONTAL, false)
                imageAdapter = ImageAdapter(imageData)
                binding.morePic.addItemDecoration(
                    LinearItemDecoration(
                        startEndSpace = 16.px,
                        betweenSpace = 2.px
                    )
                )
                binding.morePic.adapter = imageAdapter
                imageAdapter.addAll(imageDummyData)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    fun addAll(foodDummyData: ArrayList<FoodModel>) {
        mList?.addAll(foodDummyData)
    }

    private val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}