package com.example.cue_practice_management_mobile.domain.models

import java.util.Date

data class AcademicProgram(
    val _id: String,
    val name: String,
    val description: String,
    val faculty: Faculty,
    val durationInSemesters: Int,
    val coordinatorName: String,
    val coordinatorEmail: String,
    val createdAt: Date
){

}