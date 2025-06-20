package com.example.cue_practice_management_mobile.core.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PracticeInfoColumn(company: String, tutor: String, professor: String) {
    Column(modifier = Modifier.padding(start = 16.dp)) {
        Text("Empresa", style = MaterialTheme.typography.labelMedium)
        Text(company, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Tutor", style = MaterialTheme.typography.labelMedium)
        Text(tutor, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Profesor", style = MaterialTheme.typography.labelMedium)
        Text(professor, style = MaterialTheme.typography.bodyMedium)
    }
}