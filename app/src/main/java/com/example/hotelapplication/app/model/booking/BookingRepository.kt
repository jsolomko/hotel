package com.example.hotelapplication.app.model.booking

class BookingRepository(
    private val bookingSource: BookingSource
) {
    suspend fun getBooking(): Booking {
        return bookingSource.getBooking()
    }
}