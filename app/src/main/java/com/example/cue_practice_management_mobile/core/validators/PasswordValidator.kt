package com.example.cue_practice_management_mobile.core.validators

import com.example.cue_practice_management_mobile.core.models.ValidationResult

class PasswordValidator:Validator<String> {
    override fun validate(value: String): ValidationResult {
        return if (value.length < 8) {
            ValidationResult(
                successful = false,
                errorMessage = "La contraseña debe tener al menos 8 caracteres"
            )
        } else if (!value.any { it.isDigit() }) {
            ValidationResult(
                successful = false,
                errorMessage = "La contraseña debe contener al menos un número"
            )
        } else if (!value.any { it.isUpperCase() }) {
            ValidationResult(
                successful = false,
                errorMessage = "La contraseña debe contener al menos una letra mayúscula"
            )
        } else if (!value.any { it.isLowerCase() }) {
            ValidationResult(
                successful = false,
                errorMessage = "La contraseña debe contener al menos una letra minúscula"
            )
        } else {
            ValidationResult(successful = true)
        }
    }


}