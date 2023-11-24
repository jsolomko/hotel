package com.example.hotelapplication.app.model

import com.example.hotelapplication.app.model.booking.BookingSource
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.app.model.room.RoomSource

interface SourceProvider {
     fun getHotelSource(): HotelSource
     fun getRoomSource(): RoomSource
     fun getBookingSource():BookingSource
}