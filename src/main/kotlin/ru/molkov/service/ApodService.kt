package ru.molkov.service

import ru.molkov.entity.Apod
import java.util.*

interface ApodService {

    fun findByDate(date: Date): Apod?
}