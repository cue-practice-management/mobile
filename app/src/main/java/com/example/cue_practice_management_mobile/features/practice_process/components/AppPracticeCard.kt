package com.example.cue_practice_management_mobile.features.practice_process.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLabelTag
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppSubtitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.core.ui.components.molecules.CompanyAvatarAndName
import com.example.cue_practice_management_mobile.core.ui.components.molecules.ProfessorLabel
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import java.time.format.DateTimeFormatter

@Composable
fun PracticeCard(process: PracticeProcess, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Estado de la práctica
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                AppLabelTag(text = process.status.name.replace("_", " ").uppercase())
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Título de la práctica
            AppTitleText(text = process.practiceDefinition.name)

            // Fechas
            AppSubtitleText(
                text = "${process.startDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))} – " +
                        process.endDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Empresa
            CompanyAvatarAndName(companyName = process.company.name)

            Spacer(modifier = Modifier.height(8.dp))

            // Profesor
            ProfessorLabel(professorName = process.professor.firstName)
        }
    }
}
