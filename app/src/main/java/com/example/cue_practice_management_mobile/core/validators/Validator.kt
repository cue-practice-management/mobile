package com.example.cue_practice_management_mobile.core.validators

import com.example.cue_practice_management_mobile.core.models.ValidationResult

interface Validator<T> {
    fun validate(value: T): ValidationResult
}