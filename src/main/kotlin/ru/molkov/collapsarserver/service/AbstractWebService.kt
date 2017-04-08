package ru.molkov.collapsarserver.service

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractWebService(apiBaseUrl: String) {
    private var retrofit: Retrofit =
            Retrofit.Builder()
                    .baseUrl(apiBaseUrl)
                    .client(createOkHttpClient())
                    .addConverterFactory(createConverterFactory())
                    .build()

    fun getRetrofit(): Retrofit = retrofit

    private fun createOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build()

    private fun createConverterFactory(): Converter.Factory = JacksonConverterFactory.create()
}