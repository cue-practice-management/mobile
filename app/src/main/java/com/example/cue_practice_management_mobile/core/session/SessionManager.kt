package com.example.cue_practice_management_mobile.core.session

import android.util.Log
import com.example.cue_practice_management_mobile.core.events.AuthEvent
import com.example.cue_practice_management_mobile.core.events.EventBus
import com.example.cue_practice_management_mobile.domain.models.User
import com.example.cue_practice_management_mobile.config.security.TokenManager
import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
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
        var token = tokenManager.accessToken.firstOrNull()

        if (token.isNullOrBlank()) {
            try {
                val refresh = authRepository.refreshToken()
                tokenManager.saveAccessToken(refresh.accessToken)
                tokenManager.saveRefreshToken(refresh.mobileRefreshToken)
                token = refresh.accessToken
            } catch (e: Exception) {
                return false
            }
        }

        return try {
            val user = authRepository.me()
            user != null
        } catch (e: Exception) {
            false
        }
    }

    suspend fun handleLogout() {
        tokenManager.clear()
        authRepository.logout()
        _user.value = null
        _loggedOut.value = true
    }
}

