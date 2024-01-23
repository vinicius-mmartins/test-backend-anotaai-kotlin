package com.github.viniciusmartins.catalogapi.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Catalog(
        val owner: String,
        val catalog: List<CatalogItems>
)

@Serializable
data class CatalogItems(
        val categoryTitle: String,
        val categoryDescription: String,
        val items: List<Item>
)

@Serializable
data class Item(
        val title: String,
        val description: String,
        val price: String
)
