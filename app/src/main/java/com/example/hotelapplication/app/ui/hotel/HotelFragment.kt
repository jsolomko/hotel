package com.example.hotelapplication.app.ui.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

        viewModel.getHotel()
        viewModel.hotel.observe(viewLifecycleOwner) {
            println(it)
        }

        return binding.root
    }
}