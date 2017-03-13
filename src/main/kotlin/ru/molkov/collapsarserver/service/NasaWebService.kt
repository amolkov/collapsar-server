package ru.molkov.collapsarserver.service

import ru.molkov.collapsarserver.entity.Apod
import java.util.*

interface NasaWebService {

    fun get(date: Date): Apod
}