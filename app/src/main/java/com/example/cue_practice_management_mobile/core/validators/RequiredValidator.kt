package com.example.cue_practice_management_mobile.core.validators

import com.example.cue_practice_management_mobile.core.models.ValidationResult

class RequiredValidator: Validator<String> {

    override fun validate(value: String): ValidationResult {
        return if (value.isBlank()) {
            ValidationResult(
                successful = false,
                errorMessage = "Este campo es obligatorio."
            )
        } else {
            ValidationResult(successful = true)
        }
    }
}