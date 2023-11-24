package com.example.hotelapplication.app.ui.hotel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.Singletons
import com.example.hotelapplication.app.model.hotel.Hotel
import com.example.hotelapplication.app.model.hotel.HotelRepository
import com.example.hotelapplication.app.utils.share
import kotlinx.coroutines.launch

class HotelViewModel(
    private val hotelRepository: HotelRepository = Singletons.hotelRepository
) : ViewModel() {

    private var _hotel = MutableLiveData<Hotel>()
    val hotel = _hotel.share()

    fun getHotel() {
        viewModelScope.launch {
            _hotel.value = hotelRepository.getHotel()
        }
    }
}