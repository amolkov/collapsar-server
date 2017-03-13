package ru.molkov.collapsarserver.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.molkov.collapsarserver.manager.ApodManager
import ru.molkov.collapsarserver.setting.Constants
import java.util.*

@RestController
@RequestMapping(Constants.APOD_URL)
class ApodController(val apodManager: ApodManager) {

    @GetMapping
    fun findByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") date: Date) = apodManager.findByDate(date)
}