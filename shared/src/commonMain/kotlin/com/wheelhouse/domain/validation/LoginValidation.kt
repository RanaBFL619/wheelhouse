package com.wheelhouse.domain.validation

object LoginValidation {

    const val MIN_PASSWORD_LENGTH = 6

    fun validateUsername(username: String): ValidationResult =
        when {
            username.isBlank() -> ValidationResult.Invalid("Email is required")
            !username.contains("@") -> ValidationResult.Invalid("Please enter a valid email address")
            else -> ValidationResult.Valid
        }

    fun validatePassword(password: String): ValidationResult =
        when {
            password.isBlank() -> ValidationResult.Invalid("Password is required")
            password.length < MIN_PASSWORD_LENGTH -> ValidationResult.Invalid("Password must be at least $MIN_PASSWORD_LENGTH characters")
            else -> ValidationResult.Valid
        }

    fun validateLogin(username: String, password: String): Pair<ValidationResult, ValidationResult> =
        validateUsername(username) to validatePassword(password)
}
