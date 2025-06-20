package com.example.cue_practice_management_mobile.core.data.api

import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface PracticeProcessService {

    @GET("practice-processes/{id}")
    suspend fun getPracticeProcessById(
        @Path("id") id: String
    ): PracticeProcessDetail?

    @GET("practice-processes/professor/me/current")
    suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess>


    @GET("practice-processes/student/me/current")
    suspend fun getStudentCurrentPracticeProcess(): PracticeProcess

}