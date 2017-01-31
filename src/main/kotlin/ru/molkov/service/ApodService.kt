package ru.molkov.service

import org.springframework.data.domain.Sort
import ru.molkov.entity.Apod

interface ApodService {

    fun findAll(sort: Sort = Sort(Sort.Direction.DESC, "date")): List<Apod>

    fun findOne(id: Long): Apod
}