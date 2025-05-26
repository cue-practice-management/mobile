package com.example.cue_practice_management_mobile.features.auth.services

import com.example.cue_practice_management_mobile.core.models.User
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse
import com.example.cue_practice_management_mobile.features.auth.models.RefreshTokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @GET("auth/me")
    suspend fun me(): User

    @POST("auth/login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse

    @GET("auth/refresh")
    suspend fun refreshToken(): RefreshTokenResponse

    @POST("auth/logout")
    suspend fun logout(): Void
}