package com.example.cue_practice_management_mobile.features.auth.models

data class RefreshTokenResponse(
    val accessToken: String,
    val mobileRefreshToken: String
)
