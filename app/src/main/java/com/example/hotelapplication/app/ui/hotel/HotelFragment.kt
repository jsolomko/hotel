package com.example.hotelapplication.app.ui.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.FragmentHotelBinding
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLConnection
import javax.inject.Inject

@AndroidEntryPoint
class HotelFragment : Fragment(R.layout.fragment_hotel) {
    private lateinit var binding: FragmentHotelBinding
    private val viewModel by viewModels<HotelViewModel>()
    private lateinit var viewPager: ViewPager2

    @Inject
    lateinit var urlConnection: URLConnection

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(inflater, container, false)

        initView()
        observeHotel()
        observeIOException()
        observeNavigationEvent()
        observeConnection()
        return binding.root
    }

    private fun initView() {
        binding.scrollView.isVisible = false
        binding.shimmer.startShimmer()
        viewPager = binding.viewpager
    }

    private fun observeNavigationEvent() {
        binding.btnToRooms.setOnClickListener {
            findNavController().navigate(R.id.roomFragment)
        }
    }

    private fun observeHotel() {
        viewModel.getHotel()
        viewModel.hotel.observe(viewLifecycleOwner) { hotel ->
            with(binding) {
                shimmer.stopShimmer()
                shimmer.isVisible = false
                scrollView.isVisible = true
                val images = hotel.image_urls
                viewPager.adapter = SliderAdapter(images!!, requireActivity())

                tvHotelName.text = hotel.name
                tvHotelAddress.text = hotel.adress
                tvRating.text = hotel.rating.toString()
                tvRatingName.text = hotel.rating_name
                tvMinimalPrice.text = hotel.minimal_price.toString()
                tvPriceForIt.text = hotel.price_for_it
                tvPeculiarities1.text =
                    hotel.about_the_hotel?.peculiarities?.get(0) ?: "Опция 1"
                tvPeculiarities2.text =
                    hotel.about_the_hotel?.peculiarities?.get(1) ?: "Опция 2"
                tvPeculiarities3.text =
                    hotel.about_the_hotel?.peculiarities?.get(2) ?: "Опция 3"
                tvPeculiarities4.text =
                    hotel.about_the_hotel?.peculiarities?.get(3) ?: "Опция 4"
                tvHotelDescription.text = hotel.about_the_hotel?.description
            }
        }
    }

    private fun observeIOException() {
        viewModel.iOExceptionEvent.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Ошибка сети", Toast.LENGTH_SHORT).show()
                binding.shimmer.stopShimmer()
            }
        }
    }

    private fun observeConnection() {
        viewModel.observeConnection()
        viewModel.onAvailableEvent.observe(viewLifecycleOwner) {
            if (it) viewModel.getHotel()
        }
    }

}