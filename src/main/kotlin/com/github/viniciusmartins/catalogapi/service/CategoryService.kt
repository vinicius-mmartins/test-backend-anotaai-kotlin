package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.document.Category
import com.github.viniciusmartins.catalogapi.model.dto.CatalogEmitMsg
import com.github.viniciusmartins.catalogapi.repository.CategoryRepo
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepo: CategoryRepo,
    private val catalogQueueService: CatalogQueueService
) {

    fun insert(category: Category): Category = categoryRepo.save(category)

    fun getAll(): List<Category> = categoryRepo.findAll()

    fun update(category: Category): Category {
        getById(category)
        catalogQueueService.publishMessage(CatalogEmitMsg(category.ownerId))
        return categoryRepo.save(category)
    }

    fun delete(category: Category) {
        getById(category)
        catalogQueueService.publishMessage(CatalogEmitMsg(category.ownerId))
        categoryRepo.delete(category)
    }

    private fun getById(category: Category): Category {
        return categoryRepo.findById(category.id).orElseThrow()
    }

    fun getAllByOwnerId(ownerId: String): List<Category> = categoryRepo.findAllByOwnerId(ownerId)

}