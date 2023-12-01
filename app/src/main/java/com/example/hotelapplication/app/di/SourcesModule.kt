package com.example.hotelapplication.app.di

import com.example.hotelapplication.app.model.booking.BookingSource
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.app.model.room.RoomSource
import com.example.hotelapplication.source.model.booking.RetrofitBookingSource
import com.example.hotelapplication.source.model.hotel.RetrofitHotelSource
import com.example.hotelapplication.source.model.room.RetrofitRoomSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourcesModule {

    @Binds
    abstract fun bindHotelSource(retrofitHotelSource: RetrofitHotelSource): HotelSource

    @Binds
    abstract fun bindBookingSource(bookingSource: RetrofitBookingSource): BookingSource

    @Binds
    abstract fun bindRoomSource(retrofitRoomSource: RetrofitRoomSource): RoomSource
}