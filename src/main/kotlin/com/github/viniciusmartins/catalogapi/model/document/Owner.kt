package com.github.viniciusmartins.catalogapi.model.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("owner")
data class Owner(
        @Id val ownerId: UUID,
        val name: String
)
