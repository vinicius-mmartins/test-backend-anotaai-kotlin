package com.github.viniciusmartins.catalogapi.service

import com.github.viniciusmartins.catalogapi.model.dto.Catalog
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.NoSuchKeyException
import software.amazon.awssdk.services.s3.model.PutObjectRequest

private val log = KotlinLogging.logger {}

@Service
class S3Service(
    private val s3Client: S3Client
) {
    fun uploadJson(bucket: String, key: String, json: String) {
        val putRequest = PutObjectRequest.builder()
            .key(key)
            .bucket(bucket)
            .metadata(mapOf(Pair("type", ".json")))
            .build()
        val requestBody = RequestBody.fromString(json)
        try {
            log.info { "Salvando json: $json, com chave: $key no bucket: $bucket" }
            s3Client.putObject(putRequest, requestBody)
        } catch (e: Exception) {
            log.error(e) { "Erro ao salvar no bucket: $bucket. Erro: $e" }
            throw e
        }
    }

    fun getJson(bucket: String, key: String): String {
        try {
            val responseInputStream = s3Client.getObject(
                GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build()
            )
            responseInputStream.response() //todo: debugar
            return ""
//            return Json.decodeFromString<Catalog>() //todo: como pegar a resposta do bucket?
        } catch (e: NoSuchKeyException) {
            log.info { "not found" }
            throw RuntimeException("criar exception e tratar")
        } catch (e: Exception) {
            log.error { "erro $e" }
            throw e
        }
    }


    //todo: precisaria apagar antes ou o put vai sobrescrever? testar pra ver

}