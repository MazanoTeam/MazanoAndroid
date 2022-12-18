package com.example.mazano.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mazano.common.Routes
import com.example.mazano.presentation.ui.auth.AuthGeneralScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isLogged = false
            val startDestination = if (isLogged) Routes.MAIN.route else Routes.AUTH.route
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = startDestination) {
                composable(Routes.MAIN.route) {}
                composable(Routes.AUTH.route) {
                    AuthGeneralScreen(navController = navController)
                }
                composable(Routes.WELCOME_GENERAL.route) {}
            }
        }
    }
}
