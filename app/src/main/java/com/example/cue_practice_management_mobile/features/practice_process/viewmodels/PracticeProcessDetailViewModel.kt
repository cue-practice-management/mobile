package com.example.cue_practice_management_mobile.features.practice_process.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.domain.models.PracticeProcessDetail
import com.example.cue_practice_management_mobile.domain.repositories.PracticeProcessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PracticeProcessDetailViewModel @Inject constructor(
    private val practiceProcessRepository: PracticeProcessRepository
) : ViewModel() {

    var practiceProcess by mutableStateOf<PracticeProcessDetail?>(null)
        private set

    var isLoading by mutableStateOf(true)
        private set

    fun loadPracticeProcess(processId: String) {
        viewModelScope.launch {
            isLoading = true
            practiceProcess = practiceProcessRepository.getPracticeProcessById(processId)
            isLoading = false
        }
    }
}
