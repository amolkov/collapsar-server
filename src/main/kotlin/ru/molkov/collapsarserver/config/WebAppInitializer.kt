package ru.molkov.collapsarserver.config

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext
import javax.servlet.ServletException

class WebAppInitializer : WebApplicationInitializer {
    companion object {
        private val DISPATCHER = "dispatcher"
        private val DISPATCHER_SERVLET_MAPPING = "/"
    }

    @Throws(ServletException::class)
    override fun onStartup(servletContext: ServletContext) {
        val webApplicationContext = AnnotationConfigWebApplicationContext()
        webApplicationContext.register(WebMvcConfig::class.java)

        servletContext.addListener(ContextLoaderListener(webApplicationContext))

        val servletRegistration = servletContext.addServlet(DISPATCHER, DispatcherServlet(webApplicationContext))
        servletRegistration.addMapping(DISPATCHER_SERVLET_MAPPING)
    }
}
