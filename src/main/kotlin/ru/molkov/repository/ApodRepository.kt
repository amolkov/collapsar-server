package ru.molkov.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.molkov.entity.Apod

interface ApodRepository : JpaRepository<Apod, Long>