package com.radhikayusuf.lib.auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponseModel(
    @SerialName("city")
    val city: String? = "",
    @SerialName("country")
    val country: String? = "",
    @SerialName("state")
    val state: String? = "",
    @SerialName("street")
    val street: String? = "",
    @SerialName("timezone")
    val timezone: String? = ""
)