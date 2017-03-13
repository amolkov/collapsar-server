package ru.molkov.collapsarserver.service.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.molkov.collapsarserver.entity.api.ApodDto

interface NasaApi {

    @GET("apod")
    fun getApod(@Query("api_key") apiKey: String, @Query("date") date: String): Call<ApodDto>
}