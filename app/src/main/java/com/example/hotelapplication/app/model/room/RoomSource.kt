package com.example.hotelapplication.app.model.room

interface RoomSource {
    suspend fun getRooms(): List<Room>
}