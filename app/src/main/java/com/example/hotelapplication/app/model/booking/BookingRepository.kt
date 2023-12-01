package com.example.hotelapplication.app.model.booking

import com.example.hotelapplication.app.model.EmptyFieldException
import com.example.hotelapplication.app.model.Field
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookingRepository @Inject constructor(
    private val bookingSource: BookingSource
) {
    suspend fun getBooking(): Booking {

        return bookingSource.getBooking()
    }
}