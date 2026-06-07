package com.wheelhouse.domain.usecase.auth

import com.wheelhouse.data.model.auth.LoginResponse
import com.wheelhouse.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): Result<LoginResponse> {
        return authRepository.login(username, password)
    }
}
