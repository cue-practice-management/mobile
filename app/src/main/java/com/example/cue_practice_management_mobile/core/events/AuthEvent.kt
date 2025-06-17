package com.example.cue_practice_management_mobile.core.events

sealed class AuthEvent {
    data object Logout : AuthEvent()
}