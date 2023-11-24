package com.example.hotelapplication.source.base

import com.example.hotelapplication.app.model.SourceProvider
import com.example.hotelapplication.app.model.booking.BookingSource
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.app.model.room.RoomSource
import com.example.hotelapplication.source.model.booking.RetrofitBookingSource
import com.example.hotelapplication.source.model.hotel.RetrofitHotelSource
import com.example.hotelapplication.source.model.room.RetrofitRoomSource

class RetrofitSourceProvider(private val retrofitConfig: RetrofitConfig) : SourceProvider {
    override fun getHotelSource(): HotelSource {
        return RetrofitHotelSource(retrofitConfig)
    }

    override fun getRoomSource(): RoomSource {
        return RetrofitRoomSource(retrofitConfig)
    }

    override fun getBookingSource(): BookingSource {
        return RetrofitBookingSource(retrofitConfig)
    }


}