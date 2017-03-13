package ru.molkov.collapsarserver.service

import ru.molkov.collapsarserver.entity.Apod
import java.util.*

interface ApodService {

    fun findByDate(date: Date): Apod?
}