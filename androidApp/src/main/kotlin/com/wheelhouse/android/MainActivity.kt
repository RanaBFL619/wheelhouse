package com.wheelhouse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.wheelhouse.android.ui.navigation.AppRoute
import com.wheelhouse.android.ui.navigation.AuthNavigationEffect
import com.wheelhouse.android.ui.navigation.LocalWheelhouseNavigation
import com.wheelhouse.android.ui.navigation.WheelhouseNavHost
import com.wheelhouse.android.ui.theme.WheelhouseTheme
import com.wheelhouse.android.viewmodel.AuthViewModel
import com.wheelhouse.presentation.state.AuthUiState
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WheelhouseTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val authViewModel: AuthViewModel = koinViewModel()
                    val authState by authViewModel.authState.collectAsState()
                    val startDestination = if (authState is AuthUiState.Success) {
                        AppRoute.Home.route
                    } else {
                        AppRoute.Login.route
                    }
                    CompositionLocalProvider(LocalWheelhouseNavigation provides navController) {
                        AuthNavigationEffect(navController, authViewModel)
                        WheelhouseNavHost(navController = navController, startDestination = startDestination)
                    }
                }
            }
        }
    }
}
