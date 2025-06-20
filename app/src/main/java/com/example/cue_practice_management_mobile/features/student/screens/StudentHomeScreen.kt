package com.example.cue_practice_management_mobile.features.student.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.practice_process.components.PracticeProcessSummaryCard
import com.example.cue_practice_management_mobile.features.student.viewmodels.StudentHomeViewModel

@Composable
fun StudentHomeScreen(
    navController: NavHostController,
    viewModel: StudentHomeViewModel = hiltViewModel(),
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val student = viewModel.student.collectAsState()
    val currentPracticeProcess = viewModel.currentPracticeProcess.collectAsState()

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
                PracticeProcessSummaryCard(practiceProcess = currentPracticeProcess.value)
            }
        }
    }
}