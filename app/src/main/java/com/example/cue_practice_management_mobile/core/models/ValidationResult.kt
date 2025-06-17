package com.example.cue_practice_management_mobile.core.models

data class ValidationResult(
    val successful: Boolean = false,
    val errorMessage: String? = null
)
