package ru.molkov.collapsarserver.entity.api

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import ru.molkov.collapsarserver.entity.Apod
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

fun ApodDto.toDomain(): Apod = Apod(
        id = null,
        copyright = copyright,
        date = date,
        explanation = explanation,
        mediaType = mediaType,
        title = title,
        url = url,
        urlHd = urlHd
)