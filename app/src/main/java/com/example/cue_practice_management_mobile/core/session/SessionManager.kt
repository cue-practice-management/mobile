package com.example.cue_practice_management_mobile.core.session

import android.util.Log
import com.example.cue_practice_management_mobile.core.events.AuthEvent
import com.example.cue_practice_management_mobile.core.events.EventBus
import com.example.cue_practice_management_mobile.domain.models.User
import com.example.cue_practice_management_mobile.config.security.TokenManager
import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenManager: TokenManager
)  {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _loggedOut = MutableStateFlow(false)
    val loggedOut: StateFlow<Boolean> = _loggedOut

    init {
        CoroutineScope(Dispatchers.IO).launch {
            EventBus.events.collect { event ->
                when (event) {
                    is AuthEvent.Logout -> {
                        Log.d("SessionManager", "Handling logout event")
                        handleLogout()
                    }
                }
            }
        }
    }

    suspend fun isLoggedIn(): Boolean {
        var refreshToken = tokenManager.refreshToken.firstOrNull()

        if( refreshToken.isNullOrBlank()) {
            return false
        }else{
            try {
                val user = authRepository.me()
                if (user != null) {
                    _user.value = user
                    _loggedOut.value = false
                    return true
                } else {
                    Log.e("SessionManager", "Failed to fetch user during login check")
                    return false
                }
            } catch (e: Exception) {
                Log.e("SessionManager", "Error checking login status", e)
                return false
            }
        }
    }

    suspend fun handleLogin(loginResponse: LoginResponse){
        tokenManager.saveAccessToken(loginResponse.accessToken)
        tokenManager.saveRefreshToken(loginResponse.mobileRefreshToken)

        val user = authRepository.me()
        if (user != null) {
            _user.value = user
            _loggedOut.value = false
        } else {
            Log.e("SessionManager", "Failed to fetch user after login")
        }
    }

    suspend fun handleLogout() {
        tokenManager.clear()
        authRepository.logout()
        _user.value = null
        _loggedOut.value = true
    }
}

