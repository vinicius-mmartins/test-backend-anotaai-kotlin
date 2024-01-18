package com.github.viniciusmartins.catalogapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatalogApiApplication

fun main(args: Array<String>) {
	runApplication<CatalogApiApplication>(*args)
}
