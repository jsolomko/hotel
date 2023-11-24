package com.example.hotelapplication.app

import com.example.hotelapplication.app.model.SourceProvider
import com.example.hotelapplication.app.model.hotel.HotelRepository
import com.example.hotelapplication.app.model.hotel.HotelSource
import com.example.hotelapplication.source.SourceProviderHolder

object Singletons {

    //holder
    private val hotelSourceProvider: SourceProvider by lazy {
        SourceProviderHolder.retrofitSourceProvider
    }

    //source
    private val hotelSource: HotelSource by lazy {
        hotelSourceProvider.getHotelSource()
    }

    //repositories
    val hotelRepository: HotelRepository by lazy {
        HotelRepository(hotelSource)
    }

}