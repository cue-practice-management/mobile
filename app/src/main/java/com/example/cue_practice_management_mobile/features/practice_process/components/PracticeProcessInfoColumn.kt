package com.example.cue_practice_management_mobile.features.practice_process.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppSubtitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleTextSize

@Composable
fun PracticeProcessInfoColumn(
    company: String,
    professor: String,
    student: String,
    isStudent: Boolean = true
) {
    Column(modifier = Modifier.padding(start = 16.dp)) {
        AppTitleText("Empresa", size = AppTitleTextSize.Medium)
        AppSubtitleText(company)
        Spacer(modifier = Modifier.height(4.dp))
        AppTitleText(
            text = if (isStudent) "Profesor" else "Estudiante",
            size = AppTitleTextSize.Medium
        )
        AppSubtitleText(if (isStudent) professor else student)
    }
}