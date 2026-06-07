package com.wheelhouse.android.ui.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalWheelhouseNavigation = compositionLocalOf<NavHostController> {
    error("LocalWheelhouseNavigation not provided.")
}
