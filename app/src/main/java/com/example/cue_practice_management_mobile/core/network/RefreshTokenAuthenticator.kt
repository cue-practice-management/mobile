package com.example.cue_practice_management_mobile.core.network

import com.example.cue_practice_management_mobile.core.security.TokenManager
import com.example.cue_practice_management_mobile.core.session.UserSessionManager
import com.example.cue_practice_management_mobile.features.auth.services.AuthService
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val tokenManager: TokenManager,
    private val authService: AuthService,
    private val sessionManager: UserSessionManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (responseCount(response) >= 3) return null

        return runBlocking {
            try {
                val refreshResponse = authService.refreshToken()
                tokenManager.saveToken(refreshResponse.accessToken)

                response.request().newBuilder()
                    .header("Authorization", "Bearer ${refreshResponse.accessToken}")
                    .build()
            } catch (e: Exception) {
                sessionManager.logout()
                null
            }
        }
    }

    private fun responseCount(response: Response): Int =
        generateSequence(response) { it.priorResponse() }.count()
}