package com.example.cue_practice_management_mobile.features.auth.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLogo
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLogoSize
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.domain.enums.UserRole
import com.example.cue_practice_management_mobile.domain.models.User
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
                    onLoginSuccess = { user -> navigateAfterLogin(navController, user) }
                )
            }
        }
    }
}


fun navigateAfterLogin(navController: NavHostController, user: User?) {
    val route = when (user?.role) {
        UserRole.STUDENT -> Routes.STUDENT_HOME
        UserRole.PROFESSOR -> Routes.PROFESSOR_HOME
        UserRole.ADMIN -> Routes.ADMIN_HOME
        else -> null
    }

    if (route != null) {
        navController.navigate(route) {
            popUpTo(Routes.LOGIN) { inclusive = true }
            launchSingleTop = true
        }
    } else {
        Toast.makeText(navController.context, "Rol no soportado", Toast.LENGTH_LONG).show()
    }
}
