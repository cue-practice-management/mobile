package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.DocumentType
import com.example.cue_practice_management_mobile.domain.enums.Gender
import com.example.cue_practice_management_mobile.domain.enums.UserRole
import java.util.Date

data class Professor(
    val _id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: UserRole,
    val photoUrl: String? = null,
    val academicProgram: AcademicProgram,
    val phoneNumber: Number? = null,
    val typeOfDocument: DocumentType,
    val documentNumber: String,
    val gender: Gender,
    val createdAt: Date,
    val updatedAt: Date? = null,
) {

}