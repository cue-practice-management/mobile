package com.example.cue_practice_management_mobile.features.professor.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppUserAvatar
import com.example.cue_practice_management_mobile.domain.models.Professor

@Composable
fun ProfessorHomeHeader(professor: Professor) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AppUserAvatar(
            photoUrl = professor.photoUrl,
            contentDescription = "Avatar de ${professor.firstName} ${professor.lastName}",
            size = 64 
        )
        
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            AppTitleText(
                text = "Bienvenido,",
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "${professor.firstName} ${professor.lastName}",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = professor.academicProgram.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
