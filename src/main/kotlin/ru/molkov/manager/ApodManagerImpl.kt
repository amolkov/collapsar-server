package ru.molkov.manager

import org.springframework.stereotype.Service
import ru.molkov.entity.Apod
import ru.molkov.service.ApodService
import ru.molkov.service.NasaWebService
import java.util.*

@Service
class ApodManagerImpl(val apodService: ApodService, val nasaWebService: NasaWebService) : ApodManager {

    override fun findByDate(date: Date): Apod = apodService.findByDate(date) ?: nasaWebService.get(date)
}