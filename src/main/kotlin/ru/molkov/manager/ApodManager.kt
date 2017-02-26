package ru.molkov.manager

import ru.molkov.entity.Apod
import java.util.*

interface ApodManager {

    fun findByDate(date: Date): Apod
}