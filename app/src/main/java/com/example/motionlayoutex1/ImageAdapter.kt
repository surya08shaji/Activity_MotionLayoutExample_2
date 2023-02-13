package com.example.motionlayoutex1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutex1.databinding.MoreImagesBinding
import com.example.motionlayoutex1.model.MoreImageModel


class ImageAdapter(private var mList: ArrayList<MoreImageModel>?) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    class ViewHolder(val binding: MoreImagesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MoreImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList!![position]) {
                binding.mrFood.setImageResource(imgId)
                binding.fName.text = this.title
                binding.mrTitle.text = this.title
                binding.mrDescription.text = this.description
                binding.mrCalories.text = this.calories
                binding.mrRate.text = this.rate
//                binding.mainCardView.setOnClickListener {
//
//                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    fun addAll(imageDummyData: ArrayList<MoreImageModel>) {
        mList?.addAll(imageDummyData)
    }
}