package com.example.cue_practice_management_mobile.core.validators

import com.example.cue_practice_management_mobile.core.models.ValidationResult

class EmailValidator: Validator<String> {

    override fun validate(value: String): ValidationResult {
        return if (value.isBlank()) {
            ValidationResult(
                successful = false,
                errorMessage = "Este campo es obligatorio."
            )
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            ValidationResult(
                successful = false,
                errorMessage = "El formato del correo electrónico es inválido."
            )
        } else {
            ValidationResult(successful = true)
        }
    }
}