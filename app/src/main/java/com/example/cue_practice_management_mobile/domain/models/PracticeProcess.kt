package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessCancelledBy
import com.example.cue_practice_management_mobile.domain.enums.PracticeProcessStatus
import java.time.LocalDate
import java.util.Date

data class PracticeProcess(
    val _id: String,
    val practiceDefinition: PracticeDefinition,
    val student: Student,
    val professor: Professor,
    val company: CompanyBasicInfo,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val status: PracticeProcessStatus,
    val finalGrade: Double? = null,
    val cancelledBy: PracticeProcessCancelledBy? = null,
    val cancellationDate: Date? = null,
    val cancellationReason: String? = null,
    val createdAt: Date,
    val updatedAt: Date

) {
}