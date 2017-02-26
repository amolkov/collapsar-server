package ru.molkov.service

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractWebService(apiBaseUrl: String) {
    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .client(createOkHttpClient())
                .addConverterFactory(createConverterFactory())
                .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build()
    }

    private fun createConverterFactory(): Converter.Factory = JacksonConverterFactory.create()
}