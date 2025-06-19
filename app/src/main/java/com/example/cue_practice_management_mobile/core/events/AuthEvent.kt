package com.example.cue_practice_management_mobile.core.events

import com.example.cue_practice_management_mobile.features.auth.models.LoginResponse

sealed class AuthEvent {
    data object Logout : AuthEvent()
    data class Login(val loginResponse: LoginResponse) : AuthEvent()
}