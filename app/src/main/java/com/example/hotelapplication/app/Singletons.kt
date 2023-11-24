package com.example.hotelapplication.app

import com.example.hotelapplication.app.model.SourceProvider
import com.example.hotelapplication.app.model.booking.BookingRepository
import com.example.hotelapplication.app.model.booking.BookingSource
import com.example.hotelapplication.app.model.hotel.HotelRepository
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.app.model.room.RoomRepository
import com.example.hotelapplication.app.model.room.RoomSource
import com.example.hotelapplication.source.SourceProviderHolder

object Singletons {

    //holder
    private val sourceProvider: SourceProvider by lazy {
        SourceProviderHolder.retrofitSourceProvider
    }

    //source
    private val hotelSource: HotelSource by lazy {
        sourceProvider.getHotelSource()
    }
    private val roomSource: RoomSource by lazy {
        sourceProvider.getRoomSource()
    }
    private val bookingSource: BookingSource by lazy {
        sourceProvider.getBookingSource()
    }

    //repositories
    val hotelRepository: HotelRepository by lazy {
        HotelRepository(hotelSource)
    }
    val roomRepository: RoomRepository by lazy {
        RoomRepository(roomSource)
    }
    val bookingRepository: BookingRepository by lazy {
        BookingRepository(bookingSource)
    }

}