package com.example.hotelapplication.app.model.hotel

interface HotelSource {
    suspend fun getHotel(): Hotel
}