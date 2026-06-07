package com.wheelhouse.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun WheelhouseNavHost(
    navController: NavHostController,
    startDestination: String = AppRoute.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        wheelhouseNavGraph(navController)
    }
}
