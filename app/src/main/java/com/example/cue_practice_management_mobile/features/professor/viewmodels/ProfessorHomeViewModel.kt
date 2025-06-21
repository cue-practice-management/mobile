package com.example.cue_practice_management_mobile.features.professor.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.domain.models.PracticeProcess
import com.example.cue_practice_management_mobile.domain.models.Professor
import com.example.cue_practice_management_mobile.domain.repositories.PracticeProcessRepository
import com.example.cue_practice_management_mobile.domain.repositories.ProfessorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfessorHomeViewModel @Inject constructor(
    private val professorRepository: ProfessorRepository,
    private val practiceProcessRepository: PracticeProcessRepository
) : ViewModel() {

    var professor by mutableStateOf<Professor?>(null)
        private set

    var currentPracticeProcesses by mutableStateOf(emptyList<PracticeProcess>())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        loadProfessor()
    }

    private fun loadProfessor() {
        viewModelScope.launch {
            try {
                isLoading = true
                professor = professorRepository.meProfessor()
                currentPracticeProcesses = practiceProcessRepository.getProfessorCurrentPracticeProcesses()
            } catch (e: Exception) {
                Log.d("ProfessorHomeViewModel", "Error loading professor data: ${e.message}")
                professor = null
            } finally {
                isLoading = false
            }
        }
    }
}