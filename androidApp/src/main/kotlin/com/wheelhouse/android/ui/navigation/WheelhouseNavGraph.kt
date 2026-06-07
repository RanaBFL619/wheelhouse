package com.wheelhouse.android.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wheelhouse.android.ui.screen.home.HomeScreen
import com.wheelhouse.android.ui.screen.login.LoginScreen

fun NavGraphBuilder.wheelhouseNavGraph(navController: NavHostController) {
    composable(AppRoute.Login.route) {
        Box(Modifier.fillMaxSize().safeDrawingPadding()) {
            LoginScreen()
        }
    }
    composable(AppRoute.Home.route) {
        Box(Modifier.fillMaxSize().safeDrawingPadding()) {
            HomeScreen(
                onLogout = {
                    navController.navigate(AppRoute.Login.route) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
