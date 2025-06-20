package com.example.cue_practice_management_mobile.core.data.api

import com.example.cue_practice_management_mobile.domain.models.Student
import retrofit2.http.GET

interface StudentService {
    @GET("student/me")
    suspend fun meStudent(): Student
}