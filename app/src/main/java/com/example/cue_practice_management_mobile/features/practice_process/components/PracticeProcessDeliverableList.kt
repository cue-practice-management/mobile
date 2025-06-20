package com.example.cue_practice_management_mobile.features.practice_process.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDeliverable

@Composable
fun PracticeProcessDeliverableList(
    deliverables: List<PracticeProcessDeliverable>,
    canSubmit: Boolean = false,
    canGrade: Boolean = false,
    onSubmitClick: (PracticeProcessDeliverable) -> Unit = {},
    onGradeClick: (PracticeProcessDeliverable) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Entregables",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (deliverables.isEmpty()) {
            Text("No hay entregables disponibles.")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(deliverables) { deliverable ->
                    PracticeProcessDeliverableCard(
                        deliverable = deliverable,
                        canSubmit = canSubmit,
                        canGrade = canGrade,
                        onSubmitClick = { onSubmitClick(deliverable) },
                        onGradeClick = { onGradeClick(deliverable) }
                    )
                }
            }
        }
    }
}