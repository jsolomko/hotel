package com.example.hotelapplication.source.model.room

import com.example.hotelapplication.app.model.room.Room

data class RoomDTO(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val pricePer: String?,
    val peculiarities: List<String>?,
    val imageUrls: List<String>?
) {
    fun toRoom() = Room(
        id = id,
        name = name,
        price = price,
        pricePer = pricePer,
        peculiarities = peculiarities,
        imageUrls = imageUrls
    )
}

data class RoomListDTO(val rooms: List<RoomDTO>)