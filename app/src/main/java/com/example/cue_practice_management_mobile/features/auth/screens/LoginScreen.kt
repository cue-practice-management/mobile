package com.example.cue_practice_management_mobile.features.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.AppLogo
import com.example.cue_practice_management_mobile.core.ui.components.AppLogoSize
import com.example.cue_practice_management_mobile.core.ui.components.AppTitleText
import com.example.cue_practice_management_mobile.features.auth.components.LoginForm


@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppLogo(size = AppLogoSize.ExtraLarge)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AppTitleText(
                    text = "Iniciar sesión",
                    textAlign = TextAlign.Center,
                )

                LoginForm(
                    onLoginSuccess = {
                        navController.navigate(Routes.HOME) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

