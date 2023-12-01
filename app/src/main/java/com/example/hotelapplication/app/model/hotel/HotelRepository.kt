package com.example.hotelapplication.app.model.hotel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRepository @Inject constructor(
    private val hotelSource: HotelSource
) {
    suspend fun getHotel(): Hotel {
        return hotelSource.getHotel()
    }
}