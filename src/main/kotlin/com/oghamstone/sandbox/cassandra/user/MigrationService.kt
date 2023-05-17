package com.oghamstone.sandbox.cassandra.user

import com.datastax.oss.driver.api.core.CqlSession
import jakarta.annotation.PostConstruct
import org.cognitor.cassandra.migration.Database
import org.cognitor.cassandra.migration.MigrationRepository
import org.cognitor.cassandra.migration.MigrationTask
import org.springframework.data.cassandra.config.CqlSessionFactoryBean
import org.springframework.stereotype.Service

@Service
class MigrationService {

    @PostConstruct
    fun boom() {
//        val boom = cassandraSession.`object`;
//        val boom2 = 123;
//        val database = Database(boom, "temp_keyspace")
//        val migration = MigrationTask(database, MigrationRepository())
//        migration.migrate()
    }

}