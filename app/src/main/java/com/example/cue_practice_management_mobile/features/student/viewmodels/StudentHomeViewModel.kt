package com.example.cue_practice_management_mobile.features.student.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.session.SessionManager
import com.example.cue_practice_management_mobile.domain.models.Student
import com.example.cue_practice_management_mobile.domain.models.User
import com.example.cue_practice_management_mobile.domain.repositories.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentHomeViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {
    private val _student = MutableStateFlow<Student?>(null)
    val student: StateFlow<Student?> = _student

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            _student.value = studentRepository.meStudent()
            _isLoading.value = false
        }
    }

}