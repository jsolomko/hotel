package com.example.hotelapplication.source.model.booking

import com.example.hotelapplication.app.model.booking.Booking
import java.util.*

data class BookingDTO(
    val id: Int?,
    val hotelName: String?,
    val hotelAddress: String?,
    val rating: Int?,
    val ratingName: String?,
    val departure: String?,
    val arrivalCountry: String?,
    val tourDateStart: String?,
    val tourDateStop: String?,
    val numberOfNights: Int?,
    val room: String?,
    val nutrition: String?,
    val tourPrice: Int?,
    val fuelCharge: Int?,
    val serviceCharge: Int?
) {
    fun toBooking() = Booking(
        id = id,
        hotelName = hotelName,
        hotelAddress = hotelAddress,
        rating = rating,
        ratingName = ratingName,
        departure = departure,
        arrivalCountry = arrivalCountry,
        tourDateStart = tourDateStart,
        tourDateStop = tourDateStop,
        numberOfNights = numberOfNights,
        room = room,
        nutrition = nutrition,
        tourPrice = tourPrice,
        fuelCharge = fuelCharge,
        serviceCharge = serviceCharge
    )
}