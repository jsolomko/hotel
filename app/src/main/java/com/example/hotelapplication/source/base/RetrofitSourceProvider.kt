package com.example.hotelapplication.source.base

import com.example.hotelapplication.app.model.SourceProvider
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.source.model.RetrofitHotelSource

class RetrofitSourceProvider(private val retrofitConfig: RetrofitConfig) : SourceProvider {
    override fun getHotelSource(): HotelSource {
        return RetrofitHotelSource(retrofitConfig)
    }


}