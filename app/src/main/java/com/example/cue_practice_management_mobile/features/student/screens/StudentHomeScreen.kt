package com.example.cue_practice_management_mobile.features.student.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.student.viewmodels.StudentHomeViewModel
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.viewmodels.UserSessionViewModel

@Composable
fun StudentHomeScreen(
    navController: NavHostController,
    viewModel: StudentHomeViewModel = hiltViewModel(),
    userSessionViewModel: UserSessionViewModel = hiltViewModel()
) {
    val userState = userSessionViewModel.user.collectAsState()


    LaunchedEffect(userState.value) {
        if (userState.value == null) {
            navController.navigate(Routes.LOGIN) {
                popUpTo(0)
            }
        }
    }

    userState.value?.let { user ->
        AppBaseScreenLayout(navController = navController) {
            Text(text = "Welcome, ${user.firstName}!")
        }
    }
}