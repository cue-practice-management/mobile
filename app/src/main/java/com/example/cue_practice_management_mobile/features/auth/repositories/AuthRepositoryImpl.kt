package com.example.cue_practice_management_mobile.features.auth.repositories

import com.example.cue_practice_management_mobile.core.models.User
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import com.example.cue_practice_management_mobile.features.auth.models.RefreshTokenResponse
import com.example.cue_practice_management_mobile.features.auth.services.AuthService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override suspend fun me(): User? {
        return try {
            authService.me()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun login(email: String, password: String): LoginResponse {
        return authService.login(LoginRequest(email, password))
    }

    override suspend fun refreshToken(): RefreshTokenResponse {
        return authService.refreshToken()
    }

    override suspend fun logout(): Void {
        return authService.logout()
    }
}