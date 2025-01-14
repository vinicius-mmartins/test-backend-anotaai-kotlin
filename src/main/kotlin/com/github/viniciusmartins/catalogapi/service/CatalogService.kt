package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.document.Category
import com.github.viniciusmartins.catalogapi.model.document.Product
import com.github.viniciusmartins.catalogapi.model.dto.Catalog
import com.github.viniciusmartins.catalogapi.model.dto.CatalogItems
import com.github.viniciusmartins.catalogapi.model.dto.Item
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class CatalogService(
        private val ownerService: OwnerService,
        private val categoryService: CategoryService,
        private val productService: ProductService,
        private val s3Service: S3Service,
        @Value("\${aws.bucket.name}") private val bucket: String
) {

    fun getById(ownerId: String): String = s3Service.getJson(bucket, ownerId)

    fun uploadToBucket(ownerId: String, catalog: Catalog) {
        val catalogJson = Json.encodeToString(catalog)
        s3Service.uploadJson(bucket, ownerId, catalogJson)
    }

    fun buildCatalog(ownerId: String): Catalog {
        val owner = ownerService.getById(UUID.fromString(ownerId))
        val categoryList = categoryService.getAllByOwnerId(ownerId)
        val catalogItems = mutableListOf<CatalogItems>()
        categoryList.forEach {
            val productList = productService.getByCategory(it.id.toString())
            catalogItems.add(buildCatalogItems(it, productList))
        }
        return Catalog(owner.name, catalogItems)
    }

    private fun buildItemsFromProducts(products: List<Product>): List<Item> {
        val items = mutableListOf<Item>()
        products.forEach { items.add(Item(it.title, it.description, it.price)) }
        return items
    }

    private fun buildCatalogItems(category: Category, products: List<Product>): CatalogItems {
        val items = buildItemsFromProducts(products)
        return CatalogItems(
                categoryTitle = category.title,
                categoryDescription = category.description,
                items = items
        )
    }
}