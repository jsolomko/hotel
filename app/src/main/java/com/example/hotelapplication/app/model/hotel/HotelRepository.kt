package com.example.hotelapplication.app.model.hotel

class HotelRepository(
    private val hotelSource: HotelSource
) {
    suspend fun getHotel(): Hotel {
        return hotelSource.getHotel()
    }
}