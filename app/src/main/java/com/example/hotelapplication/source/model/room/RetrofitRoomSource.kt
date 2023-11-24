package com.example.hotelapplication.source.model.room

import com.example.hotelapplication.app.model.room.Room
import com.example.hotelapplication.app.model.room.RoomSource
import com.example.hotelapplication.source.base.BaseRetrofitSource
import com.example.hotelapplication.source.base.RetrofitConfig

class RetrofitRoomSource(config: RetrofitConfig) : BaseRetrofitSource(config), RoomSource {

    private val api = retrofit.create(RoomApi::class.java)
    override suspend fun getRooms(): List<Room> {
        val roomDTO: RoomListDTO = api.getRoom()
        val rooms = roomDTO.rooms
        return rooms.map { it.toRoom() }
    }
}