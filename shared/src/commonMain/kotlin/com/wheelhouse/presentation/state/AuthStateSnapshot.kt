package com.wheelhouse.presentation.state

import com.wheelhouse.data.model.auth.UserSession

data class AuthStateSnapshot(
    val kind: String,
    val session: UserSession? = null,
    val errorMessage: String? = null
) {
    companion object {
        const val KIND_IDLE = "idle"
        const val KIND_LOADING = "loading"
        const val KIND_SUCCESS = "success"
        const val KIND_ERROR = "error"
    }
}
