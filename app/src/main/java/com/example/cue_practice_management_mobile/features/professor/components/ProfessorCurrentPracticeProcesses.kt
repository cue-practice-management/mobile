package com.example.cue_practice_management_mobile.features.professor.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.features.practice_process.components.PracticeProcessSummaryCard

@Composable
fun ProfessorCurrentPracticeProcesses(
    practiceProcesses: List<PracticeProcess>,
    navHostController: NavHostController
) {

    when {
        practiceProcesses.isEmpty() -> {
            AppTitleText(text = "No estás participando en ningún proceso de práctica actualmente.")
        }
        else -> {
            LazyColumn (
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(practiceProcesses) { process ->
                    PracticeProcessSummaryCard(process, isStudent = false, onClick = {
                        navHostController.navigate("${Routes.PRACTICE_DETAIL}/${process._id}")
                    })
                }
            }
        }
    }


}