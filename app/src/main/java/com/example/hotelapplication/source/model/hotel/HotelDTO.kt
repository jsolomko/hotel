package com.example.hotelapplication.source.model.hotel

import com.example.hotelapplication.app.model.hotel.AboutTheHotel
import com.example.hotelapplication.app.model.hotel.Hotel

data class HotelDTO(
    val id: Int?,
    val name: String?,
    val adress: String?,
    val minimal_price: Int?,
    val price_for_it: String?,
    val rating: Int?,
    val rating_name: String?,
    val image_urls: List<String>?,
    val about_the_hotel: AboutTheHotel?
) {
    fun toHotel() = Hotel(
        id = id,
        name = name,
        adress = adress,
        minimal_price = minimal_price,
        price_for_it = price_for_it,
        rating = rating,
        rating_name = rating_name,
        image_urls = image_urls,
        about_the_hotel = about_the_hotel
    )
}

data class AboutTheHotelDTO(
    val description: String,
    val peculiarities: List<String>
)