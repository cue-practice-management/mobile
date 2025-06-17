package com.example.cue_practice_management_mobile.features.splash.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.AppLogo
import com.example.cue_practice_management_mobile.core.ui.components.AppLogoSize
import com.example.cue_practice_management_mobile.features.splash.viewmodels.SplashViewModel

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val destination by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initializeUser()
    }

    LaunchedEffect(destination) {
        Log.d("SplashScreen", "Navigating to destination: $destination")
        destination?.let {
            when (it) {

                SplashViewModel.Destination.HOME -> navController.navigate(Routes.HOME) {
                    popUpTo(Routes.HOME) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }

                SplashViewModel.Destination.LOGIN -> navController.navigate(Routes.LOGIN) {
                    popUpTo(Routes.SPLASH) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }

            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AppLogo(size = AppLogoSize.ExtraExtraLarge)
        }
    }
}