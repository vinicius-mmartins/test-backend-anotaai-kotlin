package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.model.document.Owner
import com.github.viniciusmartins.catalogapi.service.OwnerService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/owner")
class OwnerController(private val ownerService: OwnerService) {

    @PostMapping
    @ResponseStatus(OK)
    fun insert(@RequestBody owner: Owner): Owner = ownerService.insert(owner)

}