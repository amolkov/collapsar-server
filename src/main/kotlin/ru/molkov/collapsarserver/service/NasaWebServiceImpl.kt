package ru.molkov.collapsarserver.service

import org.springframework.stereotype.Service
import ru.molkov.collapsarserver.config.AppConfig
import ru.molkov.collapsarserver.entity.Apod
import ru.molkov.collapsarserver.entity.api.toDomain
import ru.molkov.collapsarserver.repository.ApodRepository
import ru.molkov.collapsarserver.service.api.NasaApi
import ru.molkov.collapsarserver.setting.Constants
import ru.molkov.collapsarserver.setting.asString
import java.util.*

@Service
class NasaWebServiceImpl(val apodRepository: ApodRepository, appConfig: AppConfig) : AbstractWebService(Constants.NASA_BASE_URL), NasaWebService {
    private val NASA_API_KEY = appConfig.nasaApiKey
    private val nasaApi: NasaApi = getRetrofit().create(NasaApi::class.java)

    override fun get(date: Date): Apod {
        val call = nasaApi.getApod(apiKey = NASA_API_KEY, date = date.asString())
        val dto = call.execute().body()
        return apodRepository.save(dto.toDomain())
    }
}