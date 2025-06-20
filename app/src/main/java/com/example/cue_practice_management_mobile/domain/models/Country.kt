package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class Country (
    val _id: String,
    val name: String,
    val createdAt: Date,
    val updatedAt: Date,
)