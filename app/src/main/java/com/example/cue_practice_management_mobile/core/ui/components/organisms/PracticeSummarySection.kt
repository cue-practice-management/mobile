package com.example.cue_practice_management_mobile.core.ui.components.organisms

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppSubtitleText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppTitleText
import com.example.cue_practice_management_mobile.core.ui.components.molecules.PracticeDateCard
import com.example.cue_practice_management_mobile.core.ui.components.molecules.PracticeInfoColumn
import com.example.cue_practice_management_mobile.core.ui.constants.PracticeProgressState
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PracticeSummarySection(
    title: String,
    subtitle: String,
    progressState: PracticeProgressState,
    startDate: LocalDate,
    endDate: LocalDate,
    company: String,
    tutor: String,
    professor: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEAF7FF), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        AppTitleText(title)
        AppSubtitleText(subtitle)
        Spacer(Modifier.height(16.dp))
        PracticeProgressBar(progressState)
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            PracticeDateCard("Inicio", startDate)
            Spacer(Modifier.width(8.dp))
            PracticeDateCard("Fin", endDate)
        }
        Spacer(Modifier.height(16.dp))
        PracticeInfoColumn(company, tutor, professor)
    }
}