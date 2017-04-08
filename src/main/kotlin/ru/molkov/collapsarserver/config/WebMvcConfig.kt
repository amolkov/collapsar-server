package ru.molkov.collapsarserver.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import ru.molkov.collapsarserver.Application

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = arrayOf(Application::class))
open class WebMvcConfig : WebMvcConfigurerAdapter() {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        val converter = MappingJackson2HttpMessageConverter().apply {
            objectMapper = ObjectMapper()
            supportedMediaTypes = listOf(MediaType.APPLICATION_JSON)
        }
        converters.add(converter)
    }
}
