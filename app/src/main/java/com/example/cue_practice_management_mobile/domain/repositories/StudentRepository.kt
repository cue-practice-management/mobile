package com.example.cue_practice_management_mobile.domain.repositories

import com.example.cue_practice_management_mobile.domain.models.Student

interface StudentRepository {
    suspend fun meStudent(): Student?
}