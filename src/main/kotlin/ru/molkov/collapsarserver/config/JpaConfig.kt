package ru.molkov.collapsarserver.config

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
import ru.molkov.collapsarserver.Application
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:persistence.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(Application::class))
open class JpaConfig {

    @Value("\${dataSource.driverClassName}")
    private lateinit var dsDriverClassName: String

    @Value("\${dataSource.url}")
    private lateinit var dsUrl: String

    @Value("\${dataSource.username}")
    private lateinit var dsUsername: String

    @Value("\${dataSource.password}")
    private lateinit var dsPassword: String

    @Value("\${hibernate.dialect}")
    private lateinit var dialect: String

    @Value("\${hibernate.show_sql}")
    private lateinit var showSql: String

    @Bean
    open fun dataSource(): DataSource =
            BasicDataSource().apply {
                driverClassName = dsDriverClassName
                url = dsUrl
                username = dsUsername
                password = dsPassword
            }

    @Bean
    open fun entityManagerFactory(ds: DataSource): LocalContainerEntityManagerFactoryBean {
        val entities = ClassUtils.getPackageName(Application::class.java)
        val jpaProperties = Properties().apply {
            put(Environment.DIALECT, dialect)
            put(Environment.SHOW_SQL, showSql)
        }

        return LocalContainerEntityManagerFactoryBean().apply {
            dataSource = ds
            jpaVendorAdapter = HibernateJpaVendorAdapter()

            setPackagesToScan(entities)
            setJpaProperties(jpaProperties)
        }
    }

    @Bean
    open fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager =
            JpaTransactionManager(entityManagerFactory)
}