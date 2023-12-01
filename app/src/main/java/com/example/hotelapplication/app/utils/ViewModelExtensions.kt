package com.example.hotelapplication.app.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotelapplication.app.ui.booking.BookingViewModel
import com.example.hotelapplication.app.ui.hotel.HotelViewModel
import com.example.hotelapplication.app.ui.room.RoomViewModel


/*@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            HotelViewModel::class.java -> HotelViewModel() as T
            RoomViewModel::class.java -> RoomViewModel() as T
            BookingViewModel::class.java -> BookingViewModel() as T
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}*/

typealias ViewModelCreator<VM> = () -> VM

class ViewModelFactory<VM : ViewModel>(
    private val viewModelCreator: ViewModelCreator<VM>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelCreator() as T
    }
}

inline fun <reified VM : ViewModel> Fragment.viewModelCreator(noinline creator: ViewModelCreator<VM>): Lazy<VM> {
    return viewModels { ViewModelFactory(creator) }
}

fun <T> MutableLiveData<T>.share(): LiveData<T> = this