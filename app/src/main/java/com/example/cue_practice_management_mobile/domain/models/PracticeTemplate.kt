package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class PracticeTemplate(
    val _id: String,
    val name: String,
    val description: String? = null,
    val deliverables: List<PracticeTemplateDeliverable>,
    val formats: List<PracticeTemplateFormat>,
    val createdAt: Date,
    val updatedAt: Date
) {
}