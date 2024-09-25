/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.repository

import com.vclip.mercy.common.Resource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
abstract class BaseApiResponse {
    suspend inline fun <reified T,U> safeApiCall(
        httpClient : HttpClient,
        endPoint : String,
        mapper: (T) -> U
    ): Resource<U> {
        try {
            val response: HttpResponse = httpClient.get(endPoint)
            if (response.status == HttpStatusCode.OK) {
                val body = response.body<T>()
                body?.let {
                    return Resource.Success(mapper(body))
                }
            }
            return error("${response.status} ${response.bodyAsText()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    fun <T> error(errorMessage: String): Resource<T> {
        return Resource.Error("Api call failed $errorMessage")
    }
}