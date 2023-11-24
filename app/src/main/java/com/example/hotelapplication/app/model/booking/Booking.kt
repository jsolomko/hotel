package com.example.hotelapplication.app.model.booking

import java.util.*

data class Booking(
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
)