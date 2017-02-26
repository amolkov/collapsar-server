package ru.molkov.service

import ru.molkov.entity.Apod
import java.util.*

interface NasaWebService {

    fun get(date: Date): Apod
}