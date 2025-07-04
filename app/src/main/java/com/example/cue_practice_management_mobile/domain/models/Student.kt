package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.DocumentType
import com.example.cue_practice_management_mobile.domain.enums.Gender
import com.example.cue_practice_management_mobile.domain.enums.UserRole
import java.util.Date

data class Student(
    val _id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: UserRole,
    val photoUrl: String? = null,
    val academicProgram: AcademicProgram,
    val phoneNumber: String?,
    val typeOfDocument: DocumentType,
    val gender: Gender,
    val documentNumber: String?,
    val currentSemester: Int,
    val currentCompany: Company?,
    val curriculumUrl: String?,
    val epsCertificationUrl: String?,
    val createdAt: Date,
    val updatedAt: Date,
)