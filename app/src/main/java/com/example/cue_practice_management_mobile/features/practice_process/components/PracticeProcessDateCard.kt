package com.example.cue_practice_management_mobile.features.practice_process.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppDateBox
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleTextSize
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun PracticeProcessDateCard(label: String, date: LocalDate) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AppTitleText(label, size =  AppTitleTextSize.Small)
        Spacer(modifier = Modifier.height(4.dp))
        AppDateBox(day = date.dayOfMonth, month = date.month.getDisplayName(TextStyle.FULL, Locale.getDefault()), year = date.year)
    }
}