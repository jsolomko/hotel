package com.example.hotelapplication.app.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.hotelapplication.R
import com.example.hotelapplication.app.ui.booking.TouristRepository
import com.example.hotelapplication.databinding.ItemTouristBinding

class TouristCustomView @JvmOverloads constructor(
    private val counter: Int,
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var binding: ItemTouristBinding


    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.item_tourist, this, true)
        binding = ItemTouristBinding.bind(this)
        fillView()
    }

    fun fillView() {
        val tourists = TouristRepository()
        binding.tvTouristCounterName.text = tourists.getTouristName(counter)

        binding.imageViewExpand.setOnClickListener {
            if (binding.touristListLayout.visibility == View.VISIBLE) {
                binding.touristListLayout.visibility = View.GONE
                binding.imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            } else {
                binding.touristListLayout.visibility = View.VISIBLE
                binding.imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            }
        }
    }


}