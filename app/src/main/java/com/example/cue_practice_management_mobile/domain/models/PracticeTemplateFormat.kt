package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class PracticeTemplateFormat(
    val _id: String,
    val name: String,
    val description: String,
    val fileUrl: String,
    val createdAt: Date,
    val updatedAt: Date
) {
}