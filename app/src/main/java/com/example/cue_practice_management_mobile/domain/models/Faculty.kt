package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class Faculty(
    val _id: String,
    val name: String,
    val description: String,
    val deanName: String,
    val deanEmail: String,
    val createdAt: Date? = null,
    val updatedAt: Date? = null
) {

}