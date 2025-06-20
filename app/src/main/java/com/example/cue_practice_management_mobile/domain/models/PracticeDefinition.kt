package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class PracticeDefinition(
    val _id: String,
    val name: String,
    val description: String,
    val semester: Int,
    val academicProgram: AcademicProgram,
    val practiceTemplate: PracticeTemplate,
    val createdAt: Date,
    val updatedAt: Date
) {
}