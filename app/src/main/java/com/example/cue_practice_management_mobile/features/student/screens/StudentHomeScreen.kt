package com.example.cue_practice_management_mobile.features.student.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.practice_process.components.PracticeProcessSummaryCard
import com.example.cue_practice_management_mobile.features.student.components.StudentHomeHeader
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
                Column(modifier = Modifier.padding(16.dp)) {
                    StudentHomeHeader(student = student)
                    Spacer(modifier = Modifier.height(16.dp))
                    PracticeProcessSummaryCard(practiceProcess = currentPracticeProcess.value,
                        isStudent = true,
                        onClick = {
                            navController.navigate("${Routes.PRACTICE_DETAIL}/${currentPracticeProcess.value?._id}")
                        }
                    )
                }
            }
        }
    }
}