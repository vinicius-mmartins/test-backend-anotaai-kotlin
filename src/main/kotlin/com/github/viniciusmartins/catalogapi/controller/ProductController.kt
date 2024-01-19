package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.model.document.Product
import com.github.viniciusmartins.catalogapi.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController (private val productService: ProductService) {

    @PostMapping
    fun insert(@RequestBody product: Product) = productService.insert(product)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() = productService.getAll()

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(product: Product) = productService.update(product)

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun delete(product: Product) = productService.delete(product)
    
}