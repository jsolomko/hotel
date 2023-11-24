package com.example.hotelapplication.app.model.booking

interface BookingSource {
    suspend fun getBooking(): Booking
}