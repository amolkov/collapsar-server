package ru.molkov.collapsarserver.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.molkov.collapsarserver.entity.Apod
import java.util.*

@Repository
interface ApodRepository : JpaRepository<Apod, Long> {

    @Query("SELECT a FROM Apod a WHERE a.date = :date")
    fun findByDate(@Param("date") date: Date): Apod?
}