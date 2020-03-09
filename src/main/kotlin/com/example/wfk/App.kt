package com.example.wfk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableDatastoreRepositories
@EnableWebFlux
class App

fun main() {
	runApplication<App>()
}
