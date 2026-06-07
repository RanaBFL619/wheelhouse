package com.wheelhouse.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wheelhouse.data.model.auth.UserSession
import com.wheelhouse.presentation.state.AuthUiState
import com.wheelhouse.presentation.viewmodel.AuthSharedViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class AuthViewModel(
    private val shared: AuthSharedViewModel
) : ViewModel() {

    val authState: StateFlow<AuthUiState> =
        shared.authState.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = shared.getStoredSession()?.let { AuthUiState.Success(it) } ?: AuthUiState.Idle
        )

    val userSession: StateFlow<UserSession?> =
        shared.userSession.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            null
        )

    fun login(username: String, password: String) = shared.login(username, password)
    fun logout() = shared.logout()
    fun clearError() = shared.clearError()
}
