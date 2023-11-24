package com.example.hotelapplication.app.model

import com.example.hotelapplication.app.model.hotel.HotelSource

interface SourceProvider {
     fun getHotelSource(): HotelSource
}