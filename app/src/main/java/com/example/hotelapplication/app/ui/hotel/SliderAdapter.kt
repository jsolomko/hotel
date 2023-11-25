package com.example.hotelapplication.app.ui.hotel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.ItemSliderBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SliderAdapter(
    private val images: List<String>,
    private val context: Context
) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Glide.with(context)
                .load(imageUrl)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSliderBinding.inflate(inflater, parent, false)
        return SliderViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(images[position])
    }
}