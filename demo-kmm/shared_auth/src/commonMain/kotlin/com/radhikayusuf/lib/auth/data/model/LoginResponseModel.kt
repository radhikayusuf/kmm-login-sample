package com.radhikayusuf.lib.auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    @SerialName("dateOfBirth")
    val dateOfBirth: String? = "",
    @SerialName("email")
    val email: String? = "",
    @SerialName("firstName")
    val firstName: String? = "",
    @SerialName("gender")
    val gender: String? = "",
    @SerialName("id")
    val id: String? = "",
    @SerialName("lastName")
    val lastName: String? = "",
    @SerialName("location")
    val locationResponseModel: LocationResponseModel? = LocationResponseModel(),
    @SerialName("phone")
    val phone: String? = "",
    @SerialName("picture")
    val picture: String? = "",
    @SerialName("registerDate")
    val registerDate: String? = "",
    @SerialName("title")
    val title: String? = ""
)