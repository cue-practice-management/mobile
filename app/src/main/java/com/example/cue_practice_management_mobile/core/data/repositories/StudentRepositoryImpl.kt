package com.example.cue_practice_management_mobile.core.data.repositories

import com.example.cue_practice_management_mobile.core.data.api.StudentService
import com.example.cue_practice_management_mobile.domain.models.Student
import com.example.cue_practice_management_mobile.domain.repositories.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentService: StudentService
): StudentRepository {
    override suspend fun meStudent(): Student? = try {
        studentService.meStudent()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}