package ru.molkov.service

import org.springframework.stereotype.Service
import ru.molkov.entity.Apod
import ru.molkov.repository.ApodRepository
import java.util.*

@Service
class ApodServiceImpl(val apodRepository: ApodRepository) : ApodService {

    override fun findByDate(date: Date): Apod? = apodRepository.findByDate(date)
}