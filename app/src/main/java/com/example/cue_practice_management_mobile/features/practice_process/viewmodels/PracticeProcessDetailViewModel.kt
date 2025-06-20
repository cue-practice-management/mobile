package com.example.cue_practice_management_mobile.features.practice_process.viewmodels

import com.example.cue_practice_management_mobile.domain.repositories.PracticeProcessRepository
import javax.inject.Inject

class PracticeProcessDetailViewModel @Inject constructor(
    private val practiceProcessRepository: PracticeProcessRepository
) {
    var practiceProcess:P
}