package com.oghamstone.sandbox.cassandra.user


import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*


@Table
class User {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    var id: UUID? = null
    @Column("name")
    var name: String? = null
//    @Column("test")
//    var test: String? = null
}