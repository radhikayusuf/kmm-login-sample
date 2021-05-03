package com.radhikayusuf.lib.auth.data.services

import com.radhikayusuf.lib.auth.data.model.BaseResponse
import com.radhikayusuf.lib.auth.data.model.LoginResponseModel
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/10/21
 */
class AuthServices {
    companion object {
        private const val URL =
            "https://dummyapi.io/data/api"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun login(key: String): BaseResponse<LoginResponseModel> {
        return try {
            val result: LoginResponseModel = httpApiClient.get("${URL}/user/$key") {
                contentType(ContentType.Application.Json)
                headers {
                    append("app-id", "60895136601169f838c43877")
                }
            }
            BaseResponse(result, 200, "success")
        } catch (e: Exception) {
            return BaseResponse(null, -1, e.message.orEmpty())
        }
    }
}
