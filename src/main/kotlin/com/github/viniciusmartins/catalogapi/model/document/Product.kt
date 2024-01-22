package com.github.viniciusmartins.catalogapi.model.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "product")
data class Product(
        @Id val id: UUID,
        val ownerId: String,
        val title: String,
        val price: String,
        val description: String,
        val categoryId: String
)
