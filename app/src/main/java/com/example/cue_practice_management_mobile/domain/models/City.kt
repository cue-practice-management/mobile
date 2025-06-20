package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class City(
    val _id: String,
    val name: String,
    val country: Country,
    val createdAt: Date,
    val updatedAt: Date,
)