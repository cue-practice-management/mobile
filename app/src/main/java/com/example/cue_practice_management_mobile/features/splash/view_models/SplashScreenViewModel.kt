package com.example.cue_practice_management_mobile.features.splash.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.session.UserSessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userSessionManager: UserSessionManager
) : ViewModel() {

    private val _uiState = MutableStateFlow<Destination?>(null)
    val uiState: StateFlow<Destination?> = _uiState.asStateFlow()

    fun initializeUser() {
        viewModelScope.launch {
            val loggedIn = userSessionManager.initialize()
            _uiState.value = if (loggedIn) Destination.HOME else Destination.LOGIN
        }
    }

    enum class Destination {
        HOME, LOGIN
    }
}
