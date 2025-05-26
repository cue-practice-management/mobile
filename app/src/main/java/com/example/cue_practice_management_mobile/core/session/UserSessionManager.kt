package com.example.cue_practice_management_mobile.core.session

import com.example.cue_practice_management_mobile.core.models.User
import com.example.cue_practice_management_mobile.core.security.TokenManager
import com.example.cue_practice_management_mobile.features.auth.repositories.AuthRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSessionManager @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenManager: TokenManager
) {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _loggedOut = MutableStateFlow(false)
    val loggedOut: StateFlow<Boolean> = _loggedOut

    suspend fun initialize(): Boolean {
        return try {
            _user.value = authRepository.me()
            true
        } catch (e: Exception) {
            try {
                val refresh = authRepository.refreshToken()
                tokenManager.saveToken(refresh.accessToken)
                _user.value = authRepository.me()
                _user.value != null
            } catch (e: Exception) {
                false
            }
        }
    }

    suspend fun logout() {
        tokenManager.clear()
        authRepository.logout()
        _user.value = null
        _loggedOut.value = true
    }
}
