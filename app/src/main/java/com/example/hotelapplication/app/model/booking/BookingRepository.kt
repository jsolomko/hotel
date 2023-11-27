package com.example.hotelapplication.app.model.booking

import com.example.hotelapplication.app.model.EmptyFieldException
import com.example.hotelapplication.app.model.Field

class BookingRepository(
    private val bookingSource: BookingSource
) {
    suspend fun getBooking(): Booking {

        return bookingSource.getBooking()
    }
}