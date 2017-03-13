package ru.molkov.collapsarserver.service

import org.springframework.stereotype.Service
import ru.molkov.collapsarserver.entity.Apod
import ru.molkov.collapsarserver.repository.ApodRepository
import java.util.*

@Service
class ApodServiceImpl(val apodRepository: ApodRepository) : ApodService {

    override fun findByDate(date: Date): Apod? = apodRepository.findByDate(date)
}