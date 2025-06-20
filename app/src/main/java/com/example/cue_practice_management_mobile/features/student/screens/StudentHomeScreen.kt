package com.example.cue_practice_management_mobile.features.student.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.student.viewmodels.StudentHomeViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cue_practice_management_mobile.core.navigation.NAV_ITEMS
import com.example.cue_practice_management_mobile.core.navigation.Routes

@Composable
fun StudentHomeScreen(
    navController: NavHostController,
    viewModel: StudentHomeViewModel = hiltViewModel()
) {
    val userState = viewModel.user.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: NAV_ITEMS.HOME.route

    LaunchedEffect(userState.value) {
        if (userState.value == null) {
            navController.navigate(Routes.LOGIN) {
                popUpTo(0)
            }
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        userState.value?.let { user ->
            AppBaseScreenLayout(
                user = user,
                selectedRoute = currentRoute,
                onLogout = {
                    viewModel.logout()
                },
                onNavItemSelected = { route -> navController.navigate(route) }
            ) {
                Text(text = "Welcome, ${user.firstName}!")
            }
        }
    }
}