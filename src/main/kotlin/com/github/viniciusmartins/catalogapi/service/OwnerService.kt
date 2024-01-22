package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.document.Owner
import com.github.viniciusmartins.catalogapi.repository.OwnerRepo
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OwnerService(private val ownerRepo: OwnerRepo) {

    fun insert(owner: Owner): Owner = ownerRepo.save(owner)

    fun getById(id: UUID): Owner = ownerRepo.findById(id).orElseThrow()

}