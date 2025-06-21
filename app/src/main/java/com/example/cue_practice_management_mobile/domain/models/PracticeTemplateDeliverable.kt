package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class PracticeTemplateDeliverable(
    val _id: String,
    val title: String,
    val description: String? = null,
    val estimatedDueOffsetDays: Int,
    val createdAt: Date,
    val updatedAt: Date
) {
}