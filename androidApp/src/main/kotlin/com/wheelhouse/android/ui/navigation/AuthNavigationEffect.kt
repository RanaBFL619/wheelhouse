package com.wheelhouse.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.wheelhouse.android.viewmodel.AuthViewModel
import com.wheelhouse.presentation.state.AuthUiState
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthNavigationEffect(
    navController: NavHostController,
    authViewModel: AuthViewModel = koinViewModel()
) {
    val authState by authViewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        when (authState) {
            is AuthUiState.Success -> {
                val currentDest = navController.currentDestination?.route
                if (currentDest == AppRoute.Login.route) {
                    delay(150)
                    navController.navigate(AppRoute.Home.route) {
                        launchSingleTop = true
                        popUpTo(AppRoute.Login.route) { inclusive = true }
                    }
                }
            }
            is AuthUiState.Idle -> {
                val currentDest = navController.currentDestination?.route
                if (!AppRoute.isUnauthenticatedRoute(currentDest)) {
                    delay(100)
                    navController.navigate(AppRoute.Login.route) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
            else -> {}
        }
    }
}
