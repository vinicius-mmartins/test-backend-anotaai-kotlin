package com.github.viniciusmartins.catalogapi.repository

import com.github.viniciusmartins.catalogapi.model.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : MongoRepository<Product, String>