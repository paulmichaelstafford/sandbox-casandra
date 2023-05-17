package com.oghamstone.sandbox.cassandra.user

import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import jakarta.annotation.PostConstruct
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.core.InsertOptions
import org.springframework.data.cassandra.core.InsertOptions.InsertOptionsBuilder
import org.springframework.data.cassandra.core.query.Criteria
import org.springframework.data.cassandra.core.query.Query
import org.springframework.data.cassandra.core.query.isEqualTo
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(private val cassandraTemplate: CassandraTemplate) {

    @PostConstruct
    fun startUp() {
        val u = User()
        u.id = UUID.randomUUID()
        u.name = "12345"
        cassandraTemplate.insert(u, InsertOptions.builder().ttl(60).build())
        val criteria = Criteria.where("id").isEqualTo(u.id)
        val boom = cassandraTemplate.selectOne(Query.query(criteria), User::class.java)
        println("${boom.id}")
    }
}