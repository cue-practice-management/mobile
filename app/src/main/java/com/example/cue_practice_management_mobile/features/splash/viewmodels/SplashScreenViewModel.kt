package com.example.cue_practice_management_mobile.features.splash.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.session.SessionManager
import com.example.cue_practice_management_mobile.domain.enums.UserRole
import com.example.cue_practice_management_mobile.domain.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Optional
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userSessionManager: SessionManager
) : ViewModel() {

    private val _uiState = MutableStateFlow<Destination?>(null)
    val uiState: StateFlow<Destination?> = _uiState.asStateFlow()

    fun initializeUser() {
        viewModelScope.launch {
            Log.d("SplashViewModel", "Initializing user session")
            val user = userSessionManager.initializeUser()
            Log.d("SplashViewModel", "User logged in: $user")
            _uiState.value = getDestination(user)
        }
    }

    enum class Destination {
        LOGIN,
        STUDENT_HOME,
        PROFESSOR_HOME,
        ADMIN_HOME,
    }

    private fun getDestination(user: Optional<User>): Destination {
        if(user.isEmpty) return Destination.LOGIN

        return when (user.get().role) {
            UserRole.ADMIN -> Destination.ADMIN_HOME
            UserRole.STUDENT -> Destination.STUDENT_HOME
            UserRole.PROFESSOR-> Destination.PROFESSOR_HOME
            else -> Destination.LOGIN
        }

    }

}
