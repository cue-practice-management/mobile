package com.example.cue_practice_management_mobile.core.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.session.SessionManager
import com.example.cue_practice_management_mobile.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSessionViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel() {
    val user: StateFlow<User?> = sessionManager.user

    fun logout() {
        viewModelScope.launch {
            sessionManager.handleLogout()
        }
    }
}