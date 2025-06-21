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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppButton
import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessDeliverableStatus
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDeliverable
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun PracticeProcessDeliverableCard(
    deliverable: PracticeProcessDeliverable,
    canSubmit: Boolean = false,
    canGrade: Boolean = false,
    onSubmitClick: () -> Unit = {},
    onGradeClick: () -> Unit = {}
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = deliverable.title,
                    style = MaterialTheme.typography.titleMedium
                )

            }

            Spacer(Modifier.height(4.dp))

            deliverable.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                buildAnnotatedString {
                    append("Fecha límite: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(deliverable.dueDate.format(DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.getDefault())))
                    }
                },
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(Modifier.height(12.dp))

            when {
                canSubmit && deliverable.status in listOf(
                    PracticeProcessDeliverableStatus.PENDING,
                    PracticeProcessDeliverableStatus.SCHEDULED
                ) -> {
                    AppButton(
                        text = "Entregar",
                        onClick = onSubmitClick,
                        modifier = Modifier.align(Alignment.Start)
                    )
                }

                canGrade && deliverable.status == PracticeProcessDeliverableStatus.SUBMITTED -> {
                    AppButton(
                        text = "Calificar",
                        onClick = onGradeClick,
                        modifier = Modifier.align(Alignment.Start)
                    )
                }
            }
        }
    }
}