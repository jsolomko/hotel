package com.example.hotelapplication.source.model.room

import retrofit2.http.GET

interface RoomApi {
    @GET("8b532701-709e-4194-a41c-1a903af00195")
   suspend fun getRoom(): RoomListDTO
}