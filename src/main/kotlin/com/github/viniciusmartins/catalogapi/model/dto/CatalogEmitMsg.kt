package com.github.viniciusmartins.catalogapi.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogEmitMsg(val ownerId: String)
