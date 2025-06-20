package com.example.cue_practice_management_mobile.features.practice_process.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.ui.components.layouts.AppBaseScreenLayout
import com.example.cue_practice_management_mobile.features.practice_process.viewmodels.PracticeProcessDetailViewModel

@Composable
fun PracticeProcessDetailScreen(
    processId: String,
    navController: NavHostController
) {
    val viewModel: PracticeProcessDetailViewModel = hiltViewModel()

    LaunchedEffect(processId) {
        viewModel.loadPracticeProcess(processId)
    }

    val practiceProcess = viewModel.practiceProcess
    val isLoading = viewModel.isLoading

    AppBaseScreenLayout(navController = navController) { user ->
        if (isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (practiceProcess != null) {
            Column(Modifier.padding(16.dp)) {
                Text("Práctica: ${practiceProcess.practiceDefinition.name}", style = MaterialTheme.typography.headlineSmall)
                Text("Estudiante: ${practiceProcess.student.firstName} ${practiceProcess.student.lastName}")
                Text("Empresa: ${practiceProcess.company.name}")
                // Agrega más detalles aquí
            }
        } else {
            Text("No se pudo cargar la información del proceso.")
        }
    }
}
