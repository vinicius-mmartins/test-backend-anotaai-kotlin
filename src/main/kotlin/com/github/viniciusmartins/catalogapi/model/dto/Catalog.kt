package com.github.viniciusmartins.catalogapi.model.dto

data class Catalog(
        val owner: String,
        val catalog: List<CatalogItems>
)

data class CatalogItems(
        val categoryTitle: String,
        val categoryDescription: String,
        val items: List<Item>
)

data class Item(
        val title: String,
        val description: String,
        val price: String
)
