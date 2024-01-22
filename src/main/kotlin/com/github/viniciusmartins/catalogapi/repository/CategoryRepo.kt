package com.github.viniciusmartins.catalogapi.repository

import com.github.viniciusmartins.catalogapi.model.document.Category
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : MongoRepository<Category, Long> {
     fun findAllByOwnerId(ownerId: String): List<Category>
}