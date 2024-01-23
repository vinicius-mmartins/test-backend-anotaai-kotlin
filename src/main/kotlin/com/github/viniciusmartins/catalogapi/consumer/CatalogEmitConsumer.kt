package com.github.viniciusmartins.catalogapi.consumer

import com.github.viniciusmartins.catalogapi.model.dto.CatalogEmitMsg
import com.github.viniciusmartins.catalogapi.service.CatalogService
import io.awspring.cloud.sqs.annotation.SqsListener
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class CatalogEmitConsumer(
    private val catalogService: CatalogService
) {

    @SqsListener("\${aws.sqs.catalog-queue}")
    fun listener(message: String) {
        log.info { "Consumindo mensagem: $message" }
        val emitMsg = Json.decodeFromString<CatalogEmitMsg>(message)
        val catalog = catalogService.buildCatalog(emitMsg.ownerId)
        //todo: publicar catalogo no s3. caso exista modificar ou reescrever?
    }

}