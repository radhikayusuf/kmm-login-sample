package com.radhikayusuf.lib.auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */
@Serializable
data class BaseResponse<T>(
    @SerialName("results")
    val data: T? = null,
    @SerialName("page")
    val status: Int? = null,
    @SerialName("message")
    val message: String? = ""
)