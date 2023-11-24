package com.example.hotelapplication.source.model.hotel

import com.example.hotelapplication.app.model.hotel.AboutTheHotel
import com.example.hotelapplication.app.model.hotel.Hotel

data class HotelDTO(
    val id: Int?,
    val name: String?,
    val address: String?,
    val minimalPrice: Int?,
    val priceForIt: String?,
    val rating: Int?,
    val ratingName: String?,
    val imageUrls: List<String>?,
    val aboutTheHotel: AboutTheHotel?
) {
    fun toHotel() = Hotel(
        id = id,
        name = name,
        address = address,
        minimalPrice = minimalPrice,
        priceForIt = priceForIt,
        rating = rating,
        ratingName = ratingName,
        imageUrls = imageUrls,
        aboutTheHotel = aboutTheHotel
    )
}

data class AboutTheHotelDTO(
    val description: String,
    val peculiarities: List<String>
)