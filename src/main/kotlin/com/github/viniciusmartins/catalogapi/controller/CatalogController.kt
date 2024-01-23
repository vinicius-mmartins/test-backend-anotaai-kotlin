package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.service.CatalogService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping("/{ownerId}")
    @ResponseStatus(OK)
    fun getById(@PathVariable("ownerId") ownerId: String): String = catalogService.getById(ownerId)

}