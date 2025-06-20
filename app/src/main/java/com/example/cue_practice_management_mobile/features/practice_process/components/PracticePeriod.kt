package com.example.cue_practice_management_mobile.features.practice_process.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLabel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun PracticePeriod(startDate: LocalDate, endDate: LocalDate) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        AppLabel("${startDate.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"))} - ${endDate.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"))}")
    }
}