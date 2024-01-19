package com.github.viniciusmartins.catalogapi.controller

import com.github.viniciusmartins.catalogapi.model.document.Category
import com.github.viniciusmartins.catalogapi.service.CategoryService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(private val categoryService: CategoryService) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun insert(@RequestBody category: Category) = categoryService.insert(category)

    @GetMapping
    @ResponseStatus(OK)
    fun getAll() = categoryService.getAll()

    @PutMapping
    @ResponseStatus(OK)
    fun update(category: Category) = categoryService.update(category)

    @DeleteMapping
    @ResponseStatus(OK)
    fun delete(category: Category) = categoryService.delete(category)

}