package com.example.hotelapplication.app.ui.room

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.model.room.Room
import com.example.hotelapplication.app.model.room.RoomRepository
import com.example.hotelapplication.app.utils.BaseViewModel
import com.example.hotelapplication.app.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val roomRepository: RoomRepository
) : BaseViewModel(context) {

    private var _rooms = MutableLiveData<List<Room>>()
    val rooms = _rooms.share()

    fun getRooms() {
        viewModelScope.safeLaunch {
            delay(1000)
            _rooms.value = roomRepository.getRooms()
        }
    }
}