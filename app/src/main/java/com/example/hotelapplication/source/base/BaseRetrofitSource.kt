package com.example.hotelapplication.source.base

import retrofit2.Retrofit

open class BaseRetrofitSource(config: RetrofitConfig) {
    val retrofit: Retrofit = config.retrofit
    val mosh = config.moshi
}