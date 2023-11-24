package com.example.hotelapplication.app.ui.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.app.ui.hotel.HotelViewModel
import com.example.hotelapplication.app.utils.ViewModelFactory
import com.example.hotelapplication.databinding.FragmentBookingBinding
import com.example.hotelapplication.databinding.FragmentHotelBinding

class BookingFragment : Fragment(R.layout.fragment_booking) {
    lateinit var binding: FragmentBookingBinding
    private val viewModel: BookingViewModel by viewModels { ViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingBinding.inflate(inflater, container, false)

        viewModel.getBooking()
        viewModel.booking.observe(viewLifecycleOwner) {
            println(it)
        }



        return binding.root
    }
}