package com.example.cue_practice_management_mobile.domain.repositories

import com.example.cue_practice_management_mobile.domain.models.Professor

interface ProfessorRepository {
    suspend fun meProfessor(): Professor?
}