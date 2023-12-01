package com.example.hotelapplication.app.ui.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.app.model.room.Room
import com.example.hotelapplication.app.model.room.RoomRepository
import com.example.hotelapplication.app.utils.share
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {

    private var _rooms = MutableLiveData<List<Room>>()
    val rooms = _rooms.share()

    fun getRooms() {
        viewModelScope.launch {
            _rooms.value = roomRepository.getRooms()
        }
    }
}