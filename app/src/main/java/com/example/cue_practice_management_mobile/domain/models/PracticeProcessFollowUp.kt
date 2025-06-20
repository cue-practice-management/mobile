package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessFollowUpMode
import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessFollowUpStatus
import java.time.LocalDate

data class PracticeProcessFollowUp(
    val _id: String,
    val status: PracticeProcessFollowUpStatus,
    val mode: PracticeProcessFollowUpMode,
    val meetingUrl: String? = null,
    val location: String? = null,
    val date: LocalDate,
    val outcomeNotes: String? = null,
    val completedAt: LocalDate? = null,
    val cancelledAt: LocalDate? = null,
    val cancellationReason: String? = null,
    val missedNotes: String? = null
)
