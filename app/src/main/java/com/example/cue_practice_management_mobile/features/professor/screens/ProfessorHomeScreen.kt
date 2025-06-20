package com.example.cue_practice_management_mobile.features.professor.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.professor.components.ProfessorHomeHeader
import com.example.cue_practice_management_mobile.features.professor.viewmodels.ProfessorHomeViewModel


@Composable
fun ProfessorHomeScreen(
    navController: NavHostController,
    viewModel: ProfessorHomeViewModel = hiltViewModel()
) {
    val professor = viewModel.professor
    val isLoading = viewModel.isLoading

    when {
        isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        professor != null -> {
            AppBaseScreenLayout(navController = navController) {
                Column(Modifier.padding(16.dp)) {
                ProfessorHomeHeader(professor = professor)
                }
            }

        }
    }
}