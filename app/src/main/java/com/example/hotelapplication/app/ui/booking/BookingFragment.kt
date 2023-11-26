package com.example.hotelapplication.app.ui.booking

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.app.ui.hotel.HotelViewModel
import com.example.hotelapplication.app.utils.ViewModelFactory
import com.example.hotelapplication.databinding.FragmentBookingBinding
import com.example.hotelapplication.databinding.FragmentHotelBinding
import com.example.hotelapplication.databinding.ItemTouristBinding

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
        viewModel.booking.observe(viewLifecycleOwner) { booking ->
            with(binding) {
                tvHotelName.text = booking.hotel_name
                tvHotelAddress.text = booking.hotel_adress

                tvDeparture.text = booking.departure
                tvArrivalCountry.text = booking.arrival_country
                tvTourDateStart.text = booking.tour_date_start
                tvTourDateStop.text = booking.tour_date_stop
                tvNumberOfNights.text = booking.number_of_nights.toString()
                tvHotelNameRoom.text = booking.hotel_name
                tvRoom.text = booking.room
                tvNutrition.text = booking.nutrition
                imageViewExpand.setOnClickListener {
                    if (touristListLayout.visibility == View.VISIBLE) {
                        touristListLayout.visibility = View.GONE
                        imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    } else {
                        touristListLayout.visibility = View.VISIBLE
                        imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    }
                }
            }
        }
        binding.imageViewAddNewTourist.setOnClickListener {
            addNewTouristCardView()
        }

        binding.btnToPay.setOnClickListener {
            findNavController().navigate(R.id.paidFragment)
        }
        return binding.root
    }

    private fun addNewTouristCardView() {
        val inflater = LayoutInflater.from(requireContext())
        val newCardView = ItemTouristBinding.inflate(inflater, null, false)

        newCardView.tvTouristCounterName.text = "Второй турист"
        newCardView.imageViewExpand.setOnClickListener {
            if (newCardView.touristListLayout.visibility == View.VISIBLE) {
                newCardView.touristListLayout.visibility = View.GONE
                newCardView.imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            } else {
                newCardView.touristListLayout.visibility = View.VISIBLE
                newCardView.imageViewExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            }
        }


        binding.touristListLayoutMain.addView(newCardView.root)
    }


}