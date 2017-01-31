package ru.molkov.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.molkov.entity.Apod
import ru.molkov.service.ApodService
import ru.molkov.setting.UrlConstants

@RestController
@RequestMapping(UrlConstants.APOD_URL)
class ApodController {

    @Autowired
    lateinit var apodService: ApodService

    @PostMapping(UrlConstants.APOD_SEARCH_URL)
    fun findAll(): List<Apod> = apodService.findAll()

    @GetMapping(UrlConstants.APOD_ID_URL)
    fun findOne(@PathVariable id: Long): Apod = apodService.findOne(id)
}