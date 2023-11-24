package com.example.hotelapplication.app.model.room

data class Room(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val pricePer: String?,
    val peculiarities: List<String>?,
    val imageUrls: List<String>?
)