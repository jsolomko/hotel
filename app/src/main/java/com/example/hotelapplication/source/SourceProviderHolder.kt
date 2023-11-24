package com.example.hotelapplication.source

import com.example.hotelapplication.app.BASE_URL
import com.example.hotelapplication.app.model.SourceProvider
import com.example.hotelapplication.source.base.RetrofitConfig
import com.example.hotelapplication.source.base.RetrofitSourceProvider
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object SourceProviderHolder {

    //retrofit
    val retrofitSourceProvider: SourceProvider by lazy {
        val moshi = Moshi.Builder().build()
        val config = RetrofitConfig(
            creteRetrofit(moshi), moshi
        )
        RetrofitSourceProvider(config)
    }

    private fun creteRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHHtpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun createOkHHtpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createAuthorizationInterceptor())
            .build()
    }

    private fun createAuthorizationInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}