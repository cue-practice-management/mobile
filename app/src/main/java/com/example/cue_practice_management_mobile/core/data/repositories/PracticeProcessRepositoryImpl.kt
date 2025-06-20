package com.example.cue_practice_management_mobile.core.data.repositories

import com.example.cue_practice_management_mobile.core.data.api.PracticeProcessService
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDetail
import com.example.cue_practice_management_mobile.domain.repositories.PracticeProcessRepository
import javax.inject.Inject

class PracticeProcessRepositoryImpl @Inject constructor(
    private val practiceProcessService: PracticeProcessService
): PracticeProcessRepository {

    override suspend fun getPracticeProcessById(id: String): PracticeProcessDetail? {
        return practiceProcessService.getPracticeProcessById(id)
    }

    override suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess> {
        return practiceProcessService.getProfessorCurrentPracticeProcesses()
    }

    override suspend fun getStudentCurrentPracticeProcess(): PracticeProcess {
        return practiceProcessService.getStudentCurrentPracticeProcess()
    }

}