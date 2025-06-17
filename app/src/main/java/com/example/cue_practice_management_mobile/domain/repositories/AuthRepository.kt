package com.example.cue_practice_management_mobile.features.auth.repositories

import com.example.cue_practice_management_mobile.core.models.User
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import com.example.cue_practice_management_mobile.features.auth.models.RefreshTokenResponse

interface AuthRepository {
    suspend fun me(): User?
    suspend fun login(loginRequest: LoginRequest): LoginResponse
    suspend fun refreshToken(): RefreshTokenResponse
    suspend fun logout(): Unit
}