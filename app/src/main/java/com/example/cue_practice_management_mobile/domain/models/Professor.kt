package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.UserRole

data class Professor(
    val _id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: UserRole,
    val photoUrl: String? = null,
    val academicProgram: AcademicProgram,
    val phoneNumber: Number? = null,

) {

}