package com.example.hotelapplication.app.ui.booking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.Singletons
import com.example.hotelapplication.app.model.booking.Booking
import com.example.hotelapplication.app.model.booking.BookingRepository
import com.example.hotelapplication.app.utils.share
import kotlinx.coroutines.launch

class BookingViewModel(
    private val bookingRepository: BookingRepository = Singletons.bookingRepository
) : ViewModel() {
    private var _booking = MutableLiveData<Booking>()
    val booking = _booking.share()

    fun getBooking() {
        viewModelScope.launch {
            _booking.value = bookingRepository.getBooking()
        }
    }

}