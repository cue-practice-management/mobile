package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessDeliverableStatus
import java.time.LocalDate

data class PracticeProcessDeliverable(
    val _id: String,
    val title: String,
    val description: String? = null,
    val dueDate: LocalDate,
    val submittedAt: LocalDate? = null,
    val submissionUrl: String? = null,
    val status: PracticeProcessDeliverableStatus,
    val grade: Double? = null,
    val gradeObservations: String? = null,
    val gradedAt: LocalDate? = null
) {
}