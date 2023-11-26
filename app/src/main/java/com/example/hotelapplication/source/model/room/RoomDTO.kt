package com.example.hotelapplication.source.model.room

import com.example.hotelapplication.app.model.room.Room

data class RoomDTO(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val price_per: String?,
    val peculiarities: List<String>?,
    val image_urls: List<String>?
) {
    fun toRoom() = Room(
        id = id,
        name = name,
        price = price,
        price_per = price_per,
        peculiarities = peculiarities,
        image_urls = image_urls
    )
}

data class RoomListDTO(val rooms: List<RoomDTO>)