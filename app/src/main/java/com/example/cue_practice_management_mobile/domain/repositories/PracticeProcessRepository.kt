package com.example.cue_practice_management_mobile.domain.repositories

import com.example.cue_practice_management_mobile.domain.models.PracticeProcess

interface PracticeProcessRepository {
    suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess>
    suspend fun getStudentCurrentPracticeProcess(): PracticeProcess
}