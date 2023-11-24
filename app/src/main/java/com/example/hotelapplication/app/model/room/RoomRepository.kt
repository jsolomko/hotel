package com.example.hotelapplication.app.model.room

class RoomRepository(
    private val roomSource: RoomSource
) {
    suspend fun getRooms(): List<Room> {
        return roomSource.getRooms()
    }
}