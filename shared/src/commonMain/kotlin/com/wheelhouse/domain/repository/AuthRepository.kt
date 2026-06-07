package com.wheelhouse.domain.repository

import com.wheelhouse.data.model.auth.LoginResponse
import com.wheelhouse.data.model.auth.UserSession

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>
    suspend fun logout()
    fun getToken(): String?
    fun getSession(): UserSession?
}
