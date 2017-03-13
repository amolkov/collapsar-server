package ru.molkov.collapsarserver.manager

import org.springframework.stereotype.Service
import ru.molkov.collapsarserver.entity.Apod
import ru.molkov.collapsarserver.service.ApodService
import ru.molkov.collapsarserver.service.NasaWebService
import java.util.*

@Service
class ApodManagerImpl(val apodService: ApodService, val nasaWebService: NasaWebService) : ApodManager {

    override fun findByDate(date: Date): Apod = apodService.findByDate(date) ?: nasaWebService.get(date)
}