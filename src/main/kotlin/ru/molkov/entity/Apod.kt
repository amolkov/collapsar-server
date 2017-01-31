package ru.molkov.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "apod")
class Apod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "copyright")
    var copyright: String = ""

    @Column(name = "date")
    var date: Date = Date()

    @Column(name = "explanation")
    var explanation: String = ""

    @Column(name = "media_type")
    var media_type: String = ""

    @Column(name = "title")
    var title: String = ""

    @Column(name = "url")
    var url: String = ""

    @Column(name = "hd_url")
    var hdUrl: String = ""

    override fun toString(): String {
        return "Apod(id=$id, copyright='$copyright', date=$date, explanation='$explanation', media_type='$media_type', title='$title', url='$url', hdUrl='$hdUrl')"
    }
}