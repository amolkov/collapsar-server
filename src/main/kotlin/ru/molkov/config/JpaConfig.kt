package ru.molkov.config

import org.apache.commons.dbcp2.BasicDataSource
import org.hibernate.cfg.Environment
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.util.ClassUtils
import ru.molkov.Application
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:persistence.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(Application::class))
open class JpaConfig {

    @Value("\${dataSource.driverClassName}")
    private lateinit var driver: String

    @Value("\${dataSource.url}")
    private lateinit var url: String

    @Value("\${dataSource.username}")
    private lateinit var username: String

    @Value("\${dataSource.password}")
    private lateinit var password: String

    @Value("\${hibernate.dialect}")
    private lateinit var dialect: String

    @Value("\${hibernate.show_sql}")
    private lateinit var showSql: String

    @Bean
    open fun dataSource(): DataSource {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = driver
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password

        return dataSource
    }

    @Bean
    open fun entityManagerFactory(dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
        val entityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
        entityManagerFactoryBean.dataSource = dataSource

        val entities = ClassUtils.getPackageName(Application::class.java)
        entityManagerFactoryBean.setPackagesToScan(entities)
        entityManagerFactoryBean.jpaVendorAdapter = HibernateJpaVendorAdapter()

        val jpaProperties = Properties()
        jpaProperties.put(Environment.DIALECT, dialect)
        jpaProperties.put(Environment.SHOW_SQL, showSql)
        entityManagerFactoryBean.setJpaProperties(jpaProperties)

        return entityManagerFactoryBean
    }

    @Bean
    open fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}