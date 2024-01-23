package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.dto.CatalogEmitMsg
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest

private val log = KotlinLogging.logger {}

@Service
class CatalogQueueService(
    private val sqsClient: SqsClient,
    @Value("\${aws.sqs.catalog-queue-url}") private val queueUrl: String
) {
    fun publishMessage(message: CatalogEmitMsg) {
        val msgBody = Json.encodeToString(message)
        try {
            sqsClient.sendMessage(
                SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(msgBody)
                    .build()
            )
        } catch (e: Exception) {
            log.error(e) { "Erro ao publicar mensagem. $e" }
            throw e
        }
    }

}