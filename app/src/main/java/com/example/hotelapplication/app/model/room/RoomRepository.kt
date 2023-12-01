package com.example.hotelapplication.app.model.room

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepository @Inject constructor(
    private val roomSource: RoomSource
) {
    suspend fun getRooms(): List<Room> {
        return roomSource.getRooms()
    }
}