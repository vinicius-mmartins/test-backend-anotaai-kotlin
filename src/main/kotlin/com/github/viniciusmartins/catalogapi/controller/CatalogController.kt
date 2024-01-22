package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.model.dto.Catalog
import com.github.viniciusmartins.catalogapi.service.CatalogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping("/{ownerId}")
    fun getById(@PathVariable("ownerId") ownerId: String): Catalog = catalogService.getById(ownerId)

}