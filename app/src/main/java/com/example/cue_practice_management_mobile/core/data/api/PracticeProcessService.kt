package com.example.cue_practice_management_mobile.core.data.api

import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import retrofit2.http.GET

interface PracticeProcessService {

    @GET("practice-processes/professor/me/current")
    suspend fun getProfessorCurrentPracticeProcesses(): List<PracticeProcess>


    @GET("practice-processes/student/me/current")
    suspend fun getStudentCurrentPracticeProcess(): PracticeProcess

}