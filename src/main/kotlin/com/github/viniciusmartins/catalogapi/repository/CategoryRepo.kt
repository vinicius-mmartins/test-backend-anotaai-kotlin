package com.github.viniciusmartins.catalogapi.repository

import com.github.viniciusmartins.catalogapi.model.document.Category
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepo : MongoRepository<Category, Long>