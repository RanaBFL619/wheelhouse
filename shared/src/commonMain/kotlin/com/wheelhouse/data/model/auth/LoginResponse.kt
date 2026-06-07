package com.wheelhouse.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String,
    val name: String? = null,
    val username: String,
    val roles: List<String>? = null,
    val defaultPage: String? = null
)
