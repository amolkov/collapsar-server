package ru.molkov.service

import org.springframework.stereotype.Service
import ru.molkov.config.AppConfig
import ru.molkov.entity.Apod
import ru.molkov.repository.ApodRepository
import ru.molkov.service.api.NasaApi
import ru.molkov.setting.Constants
import ru.molkov.setting.asString
import java.util.*

@Service
class NasaWebServiceImpl(val apodRepository: ApodRepository, appConfig: AppConfig) : AbstractWebService(Constants.NASA_BASE_URL), NasaWebService {
    private val NASA_API_KEY = appConfig.nasaApiKey
    private val nasaApi: NasaApi

    init {
        nasaApi = getRetrofit().create(NasaApi::class.java)
    }

    override fun get(date: Date): Apod {
        val call = nasaApi.getApod(apiKey = NASA_API_KEY, date = date.asString())
        val apodDto = call.execute().body()
        val apod = Apod.ModelMapper.from(apodDto)
        return apodRepository.save(apod)
    }
}