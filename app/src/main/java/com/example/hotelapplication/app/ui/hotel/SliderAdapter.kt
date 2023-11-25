package com.example.hotelapplication.app.ui.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.ItemSliderBinding

class SliderAdapter(private val images: List<Int>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Int) {
            binding.imageView.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSliderBinding.inflate(inflater,parent,false)
        return SliderViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(images[position])
    }
}