package com.example.cue_practice_management_mobile.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cue_practice_management_mobile.features.auth.screens.LoginScreen
import com.example.cue_practice_management_mobile.features.splash.screens.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.LOGIN
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.LOGIN) {
            LoginScreen()
        }

        composable(Routes.SPLASH) {
            SplashScreen(navController = navController)
        }

    }
}
