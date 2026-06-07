package com.wheelhouse.presentation.util

object AuthMessages {

    const val LOGIN_FAILED_GENERIC = "Invalid email or password. Please try again."

    fun toUserFriendlyLoginError(throwable: Throwable?): String {
        val message = throwable?.message?.lowercase().orEmpty()
        return if (message.contains("invalid")) LOGIN_FAILED_GENERIC else LOGIN_FAILED_GENERIC
    }
}
