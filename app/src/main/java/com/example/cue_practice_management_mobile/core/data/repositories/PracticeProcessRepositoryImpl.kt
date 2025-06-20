package com.example.cue_practice_management_mobile.core.data.repositories

import com.example.cue_practice_management_mobile.core.data.api.PracticeProcessService
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.domain.repositories.PracticeProcessRepository
import javax.inject.Inject

class PracticeProcessRepositoryImpl @Inject constructor(
    private val practiceProcessService: PracticeProcessService
): PracticeProcessRepository {

    override suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess> {
        return practiceProcessService.getProfessorCurrentPracticeProcesses()
    }


}