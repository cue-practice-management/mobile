package com.example.cue_practice_management_mobile.domain.repositories

import com.example.cue_practice_management_mobile.core.models.User
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import com.example.cue_practice_management_mobile.features.auth.models.RefreshTokenResponse
import com.example.cue_practice_management_mobile.core.api.AuthService
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
