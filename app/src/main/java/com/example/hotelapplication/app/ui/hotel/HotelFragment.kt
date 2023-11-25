package com.example.hotelapplication.app.ui.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hotelapplication.R
import com.example.hotelapplication.app.utils.ViewModelFactory
import com.example.hotelapplication.databinding.FragmentHotelBinding

class HotelFragment : Fragment(R.layout.fragment_hotel) {
    lateinit var binding: FragmentHotelBinding
    private val viewModel: HotelViewModel by viewModels { ViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(inflater, container, false)

        val images = listOf(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        )

        val viewPager: ViewPager2 = binding.viewpager
        viewPager.adapter = SliderAdapter(images)

        viewModel.getHotel()

        viewModel.hotel.observe(viewLifecycleOwner) { hotel ->
            with(binding) {
                tvHotelName.text = hotel.name
                tvHotelAddress.text = hotel.adress

                tvPeculiarities1.text = hotel.about_the_hotel?.peculiarities?.get(0) ?: "Опция 1"
                tvPeculiarities2.text = hotel.about_the_hotel?.peculiarities?.get(1) ?: "Опция 2"
                tvPeculiarities3.text = hotel.about_the_hotel?.peculiarities?.get(2) ?: "Опция 3"
                tvPeculiarities4.text = hotel.about_the_hotel?.peculiarities?.get(3) ?: "Опция 4"



                tvHotelDescription.text = hotel.about_the_hotel?.description

            }
        }


        return binding.root
    }
}