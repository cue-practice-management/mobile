package com.example.cue_practice_management_mobile.domain.models

import com.example.cue_practice_management_mobile.domain.enums.UserRole

open class User(
    val _id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: UserRole,
    val photoUrl: String?,
)
