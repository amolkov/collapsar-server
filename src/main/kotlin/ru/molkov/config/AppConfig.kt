package ru.molkov.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import ru.molkov.Application

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = arrayOf(Application::class))
open class AppConfig