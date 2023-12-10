package com.example.hotelapplication.app.ui.hotel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.model.hotel.Hotel
import com.example.hotelapplication.app.model.hotel.HotelRepository
import com.example.hotelapplication.app.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val hotelRepository: HotelRepository
) : ViewModel() {

    private var _hotel = MutableLiveData<Hotel>()
    val hotel = _hotel.share()

    fun getHotel() {
        viewModelScope.launch {
            delay(1000)
            _hotel.value = hotelRepository.getHotel()
        }
    }
}