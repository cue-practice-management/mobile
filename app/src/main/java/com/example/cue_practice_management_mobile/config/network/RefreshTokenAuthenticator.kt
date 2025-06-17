package com.example.cue_practice_management_mobile.config.network

import com.example.cue_practice_management_mobile.core.data.api.AuthService
import com.example.cue_practice_management_mobile.core.events.AuthEvent
import com.example.cue_practice_management_mobile.core.events.EventBus
import com.example.cue_practice_management_mobile.config.security.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    private val authService: AuthService
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (responseCount(response) >= 3) return null

        return runBlocking {
            try {
                val refreshTokenResponse = authService.refreshToken()
                tokenManager.saveAccessToken(refreshTokenResponse.accessToken)
                tokenManager.saveRefreshToken(refreshTokenResponse.mobileRefreshToken)

                response.request.newBuilder()
                    .header("Authorization", "Bearer ${refreshTokenResponse.accessToken}")
                    .build()
            } catch (e: Exception) {
                EventBus.send(AuthEvent.Logout)
                null
            }
        }
    }

    private fun responseCount(response: Response): Int =
        generateSequence(response) { it.priorResponse }.count()
}

