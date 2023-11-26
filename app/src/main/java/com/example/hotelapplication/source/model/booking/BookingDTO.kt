package com.example.hotelapplication.source.model.booking

import com.example.hotelapplication.app.model.booking.Booking
import java.util.*

data class BookingDTO(
    val id: Int?,
    val hotel_name: String?,
    val hotel_adress: String?,
    val horating: Int?,
    val rating_name: String?,
    val departure: String?,
    val arrival_country: String?,
    val tour_date_start: String?,
    val tour_date_stop: String?,
    val number_of_nights: Int?,
    val room: String?,
    val nutrition: String?,
    val tour_price: Int?,
    val fuel_charge: Int?,
    val service_charge: Int?
) {
    fun toBooking() = Booking(
        id = id,
        hotel_name = hotel_name,
        hotel_adress = hotel_adress,
        horating = horating,
        rating_name = rating_name,
        departure = departure,
        arrival_country = arrival_country,
        tour_date_start = tour_date_start,
        tour_date_stop = tour_date_stop,
        number_of_nights = number_of_nights,
        room = room,
        nutrition = nutrition,
        tour_price = tour_price,
        fuel_charge = fuel_charge,
        service_charge = service_charge
    )
}