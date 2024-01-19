package com.github.viniciusmartins.catalogapi.model.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Product(
    @Id val id: Long,
    val ownerId: String,
    val title: String,
    val price: String,
    val description: String,
    val category: String
)
