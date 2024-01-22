package com.github.viniciusmartins.catalogapi.repository

import com.github.viniciusmartins.catalogapi.model.document.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepo : MongoRepository<Product, UUID> {
    fun findAllByCategoryId(categoryId: String): List<Product>
}