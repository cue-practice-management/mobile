package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppDateBox(day: Int, month: String, year: Int) {
    Column(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = month, style = MaterialTheme.typography.labelMedium)
        Text(text = day.toString(), style = MaterialTheme.typography.titleLarge)
        Text(text = year.toString(), style = MaterialTheme.typography.labelSmall)
    }
}