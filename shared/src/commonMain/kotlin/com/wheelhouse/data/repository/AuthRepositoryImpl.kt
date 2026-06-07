package com.wheelhouse.data.repository

import com.wheelhouse.data.model.auth.LoginResponse
import com.wheelhouse.data.model.auth.UserSession
import com.wheelhouse.data.store.TokenStorage
import com.wheelhouse.domain.repository.AuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl(
    private val tokenStorage: TokenStorage
) : AuthRepository {

    override suspend fun login(username: String, password: String): Result<LoginResponse> = runCatching {
        delay(400)
        val trimmed = username.trim()
        if (trimmed.isBlank() || password.length < 6) {
            throw IllegalArgumentException("Invalid email or password")
        }
        val response = LoginResponse(
            token = "demo-token-${trimmed.hashCode()}",
            name = trimmed.substringBefore("@").replaceFirstChar { it.uppercase() },
            username = trimmed,
            roles = listOf("user"),
            defaultPage = "home"
        )
        tokenStorage.saveSession(
            UserSession(
                token = response.token,
                name = response.name,
                username = response.username,
                roles = response.roles ?: emptyList(),
                defaultPage = response.defaultPage
            )
        )
        response
    }

    override suspend fun logout() {
        tokenStorage.clearSession()
    }

    override fun getToken(): String? = tokenStorage.getToken()

    override fun getSession(): UserSession? = tokenStorage.getSession()
}
