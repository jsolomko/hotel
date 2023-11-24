package com.example.hotelapplication.source.model.booking

import com.example.hotelapplication.app.model.booking.Booking
import retrofit2.http.GET

interface BookingApi {
    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBooking():BookingDTO
}