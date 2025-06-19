package com.example.cue_practice_management_mobile.core.data.repositories

import com.example.cue_practice_management_mobile.domain.models.User
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import com.example.cue_practice_management_mobile.features.auth.models.RefreshTokenResponse
import com.example.cue_practice_management_mobile.core.data.api.AuthService
import com.example.cue_practice_management_mobile.core.events.AuthEvent
import com.example.cue_practice_management_mobile.core.events.EventBus
import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override suspend fun me(): User? = try {
        authService.me()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return authService.login(loginRequest)
    }

    override suspend fun refreshToken(): RefreshTokenResponse {
        return authService.refreshToken()
    }

    override suspend fun logout() {
        authService.logout()
        return Unit
    }
}
