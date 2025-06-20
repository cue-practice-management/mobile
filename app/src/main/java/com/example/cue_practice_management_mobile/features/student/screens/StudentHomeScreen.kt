package com.example.cue_practice_management_mobile.features.student.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.student.viewmodels.StudentHomeViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StudentHomeScreen(
    navController: NavHostController,
    viewModel: StudentHomeViewModel = hiltViewModel(),
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val student = viewModel.student.collectAsState()

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        student.value?.let { student ->
            AppBaseScreenLayout(navController = navController) {
                Text(text = "Welcome, ${student.firstName}!")
            }
        }
    }
}