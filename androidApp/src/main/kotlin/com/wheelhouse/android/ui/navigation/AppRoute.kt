package com.wheelhouse.android.ui.navigation

sealed class AppRoute(val route: String) {
    data object Login : AppRoute("login")
    data object Home : AppRoute("home")

    companion object {
        fun isUnauthenticatedRoute(route: String?): Boolean =
            route == null || route == Login.route
    }
}
