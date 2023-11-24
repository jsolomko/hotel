package com.example.hotelapplication.source.model.booking

import com.example.hotelapplication.app.model.booking.Booking
import com.example.hotelapplication.app.model.booking.BookingSource
import com.example.hotelapplication.source.base.BaseRetrofitSource
import com.example.hotelapplication.source.base.RetrofitConfig

class RetrofitBookingSource(config: RetrofitConfig) : BaseRetrofitSource(config), BookingSource {
    private val accountApi = retrofit.create(
        BookingApi::class.java
    )
    override suspend fun getBooking(): Booking {
        return accountApi.getBooking().toBooking()
    }
}