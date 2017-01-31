package ru.molkov.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import ru.molkov.entity.Apod
import ru.molkov.repository.ApodRepository

@Service
class ApodServiceImpl : ApodService {

    @Autowired
    private lateinit var apodRepository: ApodRepository

    override fun findAll(sort: Sort): List<Apod> = apodRepository.findAll(sort)

    override fun findOne(id: Long): Apod = apodRepository.findOne(id)
}