package com.example.cue_practice_management_mobile.features.practice_process.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppSubtitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PracticeProcessSummaryCard(
    practiceProcess: PracticeProcess?
) {
    if (practiceProcess == null) {
        Text("Aún no tienes un proceso de práctica activo.")
        return
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEAF7FF), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        AppTitleText(practiceProcess.practiceDefinition.name)
        AppSubtitleText(practiceProcess.practiceDefinition.description)
        Spacer(Modifier.height(16.dp))
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            PracticeProcessDateCard("Inicio", practiceProcess.startDate)
            Spacer(Modifier.width(8.dp))
            PracticeProcessDateCard("Fin", practiceProcess.endDate)
        }
        Spacer(Modifier.height(16.dp))
        PracticeProcessInfoColumn(practiceProcess.company.name, practiceProcess.professor.firstName)
    }
}