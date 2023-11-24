package com.example.hotelapplication.source.model.hotel

import com.example.hotelapplication.app.model.hotel.Hotel
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.source.base.BaseRetrofitSource
import com.example.hotelapplication.source.base.RetrofitConfig

class RetrofitHotelSource(config: RetrofitConfig) : HotelSource, BaseRetrofitSource(config) {

    private val accountApi = retrofit.create(HotelApi::class.java
    )
    override suspend fun getHotel(): Hotel {
        return accountApi.getHotel().toHotel()
    }
}