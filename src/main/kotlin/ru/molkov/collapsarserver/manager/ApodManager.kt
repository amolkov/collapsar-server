package ru.molkov.collapsarserver.manager

import ru.molkov.collapsarserver.entity.Apod
import java.util.*

interface ApodManager {

    fun findByDate(date: Date): Apod
}