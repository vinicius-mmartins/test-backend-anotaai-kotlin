package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.document.Product
import com.github.viniciusmartins.catalogapi.model.dto.CatalogEmitMsg
import com.github.viniciusmartins.catalogapi.repository.ProductRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepo: ProductRepo,
    private val catalogQueueService: CatalogQueueService
) {
    fun insert(product: Product): Product {
        catalogQueueService.publishMessage(CatalogEmitMsg(product.ownerId))
        return productRepo.save(product)
    }

    fun getAll(): List<Product> = productRepo.findAll()

    fun update(product: Product): Product {
        getById(product.id)
        catalogQueueService.publishMessage(CatalogEmitMsg(product.ownerId))
        return productRepo.save(product)
    }

    fun delete(product: Product) {
        getById(product.id)
        catalogQueueService.publishMessage(CatalogEmitMsg(product.ownerId))
        productRepo.delete(product)
    }

    fun getById(id: UUID): Product {
        return productRepo.findById(id).orElseThrow()
    }

    fun getByCategory(categoryId: String): List<Product> = productRepo.findAllByCategoryId(categoryId)

}