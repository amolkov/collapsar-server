package ru.molkov.entity.api

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ApodDto(

        @JsonProperty("copyright")
        val copyright: String,

        @JsonProperty("date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val date: Date,

        @JsonProperty("explanation")
        val explanation: String,

        @JsonProperty("media_type")
        val mediaType: String,

        @JsonProperty("title")
        val title: String,

        @JsonProperty("url")
        val url: String,

        @JsonProperty("hdurl")
        val urlHd: String,

        @JsonProperty("service_version")
        val serviceVersion: String
)