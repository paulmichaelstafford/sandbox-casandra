import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.graalvm.buildtools.native") version "0.9.20"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "com.oghamstone.sandbox"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-cassandra")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.cognitor.cassandra:cassandra-migration-spring-boot-starter:2.6.0_v4")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//tasks.register<JavaExec>("migrateCassandra") {
//	classpath = sourceSets.main.get().runtimeClasspath
////	main = "org.cassandraunit.migration.MigrationTool"
//	main = "com.oghamstone.sandbox.cassandra.CassandraApplication.kt"
//	args = listOf(
//		"-c",
//		"classpath:application.properties",
//		"-d",
//		"migrate",
//		"--all",
//		"--outputType",
//		"VERBOSE"
//	)
//}

