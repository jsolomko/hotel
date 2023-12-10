package com.example.hotelapplication.app.ui.hotel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.model.hotel.Hotel
import com.example.hotelapplication.app.model.hotel.HotelRepository
import com.example.hotelapplication.app.utils.BaseViewModel
import com.example.hotelapplication.app.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val hotelRepository: HotelRepository
) : BaseViewModel(context) {

    private var _hotel = MutableLiveData<Hotel>()
    val hotel = _hotel.share()

    fun getHotel() {
        viewModelScope.safeLaunch {
            _hotel.value = hotelRepository.getHotel()
        }
    }

}