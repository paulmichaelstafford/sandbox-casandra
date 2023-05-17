package com.oghamstone.sandbox.cassandra.config

import com.datastax.oss.driver.api.core.CqlSession
import jakarta.annotation.PostConstruct
import org.cognitor.cassandra.migration.Database
import org.cognitor.cassandra.migration.MigrationRepository
import org.cognitor.cassandra.migration.MigrationTask
import org.cognitor.cassandra.migration.spring.CassandraMigrationAutoConfiguration
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.CqlSessionFactoryBean
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories


@Configuration
@EnableCassandraRepositories
class CassandraConfig : AbstractCassandraConfiguration() {


    @Value("\${spring.cassandra.contact-points}")
    private lateinit var contactPoints: String

    @Value("\${spring.cassandra.port}")
    private lateinit var port: String

    @Value("\${spring.cassandra.username}")
    private lateinit var username: String

    @Value("\${spring.cassandra.password}")
    private lateinit var password: String

    @Value("\${spring.cassandra.schema-action}")
    private lateinit var schemaAction: String

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.valueOf(schemaAction)
    }

    override fun getKeyspaceName(): String {
        return "temp_keyspace"
    }

    @Bean
    override fun cassandraSession(): CqlSessionFactoryBean {
        val cassandraSession = super.cassandraSession()
        cassandraSession.setUsername(username)
        cassandraSession.setPassword(password)
        cassandraSession.setKeyspaceName("temp_keyspace")
        return cassandraSession
    }

    @Bean
    @Qualifier(CassandraMigrationAutoConfiguration.CQL_SESSION_BEAN_NAME)
    fun cassandraMigrationCqlSession(): CqlSession {
        return cassandraSession().`object`
    }
    @Bean
    @Primary
    fun applicationCqlSession(): CqlSession {
        return cassandraSession().`object`
    }

}