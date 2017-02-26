package ru.molkov.entity

import ru.molkov.entity.api.ApodDto
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "apod")
data class Apod(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long?,

        @Column(name = "copyright")
        val copyright: String,

        @Column(name = "date")
        val date: Date,

        @Column(name = "explanation")
        val explanation: String,

        @Column(name = "media_type")
        val mediaType: String,

        @Column(name = "title")
        val title: String,

        @Column(name = "url")
        val url: String,

        @Column(name = "hd_url")
        val urlHd: String,

        @Column(name = "created_date")
        val createdDate: Date = Date()
) {
    private constructor() : this(null, "", Date(), "", "", "", "", "", Date())

    object ModelMapper {
        fun from(dto: ApodDto): Apod =
                Apod(id = null,
                        copyright = dto.copyright,
                        date = dto.date,
                        explanation = dto.explanation,
                        mediaType = dto.mediaType,
                        title = dto.title,
                        url = dto.url,
                        urlHd = dto.urlHd)
    }
}