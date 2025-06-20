package com.example.cue_practice_management_mobile.features.practice_process.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.practice_process.viewmodels.PracticeProcessDetailViewModel

@Composable
fun PracticeProcessDetailScreen(
    processId: String,
    navController: NavHostController
) {
    val viewModel: PracticeProcessDetailViewModel = hiltViewModel();

    AppBaseScreenLayout(navController) {

    }
}