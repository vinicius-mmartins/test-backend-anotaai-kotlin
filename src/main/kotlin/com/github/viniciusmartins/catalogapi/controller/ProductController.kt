package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.model.document.Product
import com.github.viniciusmartins.catalogapi.service.ProductService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/product")
class ProductController (private val productService: ProductService) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun insert(@RequestBody product: Product) = productService.insert(product)

    @GetMapping
    @ResponseStatus(OK)
    fun getAll() = productService.getAll()

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    fun getById(@PathVariable("id") id: UUID) = productService.getById(id)

    @PutMapping
    @ResponseStatus(OK)
    fun update(product: Product) = productService.update(product)

    @DeleteMapping
    @ResponseStatus(OK)
    fun delete(product: Product) = productService.delete(product)

}