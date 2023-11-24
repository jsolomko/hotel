package com.example.hotelapplication.source.model.hotel

import retrofit2.http.GET

interface HotelApi {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel(): HotelDTO
}