package com.example.cue_practice_management_mobile.core.session

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.cue_practice_management_mobile.core.events.AuthEvent
import com.example.cue_practice_management_mobile.core.events.EventBus
import com.example.cue_practice_management_mobile.core.navigation.Routes

@Composable
fun SessionObserver(navController: NavController) {

    LaunchedEffect(Unit) {
        EventBus.events.collect { event ->
            when (event) {
                is AuthEvent.Logout -> {
                    Log.d("SessionObserver", "User logged out, navigating to login screen")
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
                else -> Unit
            }
        }
    }
}
