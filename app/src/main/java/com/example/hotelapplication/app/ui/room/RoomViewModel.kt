package com.example.hotelapplication.app.ui.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.Singletons
import com.example.hotelapplication.app.model.room.Room
import com.example.hotelapplication.app.model.room.RoomRepository
import com.example.hotelapplication.app.utils.share
import kotlinx.coroutines.launch

class RoomViewModel(
    private val roomRepository: RoomRepository = Singletons.roomRepository
) : ViewModel() {

    private var _rooms = MutableLiveData<List<Room>>()
    val rooms = _rooms.share()

    fun getRooms() {
        viewModelScope.launch {
            _rooms.value = roomRepository.getRooms()
        }
    }
}