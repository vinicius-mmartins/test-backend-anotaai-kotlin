package com.github.viniciusmartins.catalogapi.model.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "category")
data class Category(
    @Id val id: Long,
    val title: String,
    val description: String,
    val ownerId: String
)
