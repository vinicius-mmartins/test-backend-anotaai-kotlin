package com.github.viniciusmartins.catalogapi.repository

import com.github.viniciusmartins.catalogapi.model.document.Owner
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OwnerRepo : MongoRepository<Owner, UUID>
