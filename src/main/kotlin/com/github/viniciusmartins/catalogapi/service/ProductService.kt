package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.document.Product
import com.github.viniciusmartins.catalogapi.repository.ProductRepo
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepo: ProductRepo
) {
    fun insert(product: Product): Product = productRepo.save(product)

    fun getAll(): List<Product> = productRepo.findAll()

    fun update(product: Product): Product {
        getById(product)
        return productRepo.save(product)
    }

    fun delete(product: Product) {
        getById(product)
        productRepo.delete(product)
    }

    private fun getById(product: Product): Product {
        return productRepo.findById(product.id).orElseThrow()
    }
}