package com.example.cue_practice_management_mobile.domain.repositories

import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDetail

interface PracticeProcessRepository {
    suspend fun getPracticeProcessById(id: String): PracticeProcessDetail?
    suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess>
    suspend fun getStudentCurrentPracticeProcess(): PracticeProcess
}