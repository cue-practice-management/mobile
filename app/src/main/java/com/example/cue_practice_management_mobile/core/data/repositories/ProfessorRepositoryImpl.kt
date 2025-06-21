package com.example.cue_practice_management_mobile.core.data.repositories

import android.util.Log
import com.example.cue_practice_management_mobile.core.data.api.ProfessorService
import com.example.cue_practice_management_mobile.domain.models.Professor
import com.example.cue_practice_management_mobile.domain.repositories.ProfessorRepository
import javax.inject.Inject

class ProfessorRepositoryImpl @Inject constructor(
    private val professorService: ProfessorService
) : ProfessorRepository {

    override suspend fun meProfessor(): Professor? {
        return try {
            professorService.meProfessor()
        } catch (e: Exception) {
            Log.d("ProfessorRepositoryImpl", "Error fetching professor data: ${e.message}")
            null
        }
    }
}