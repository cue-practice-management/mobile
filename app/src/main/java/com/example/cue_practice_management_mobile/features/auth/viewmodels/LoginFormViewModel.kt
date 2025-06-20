package com.example.cue_practice_management_mobile.features.auth.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.session.SessionManager
import com.example.cue_practice_management_mobile.core.validators.EmailValidator
import com.example.cue_practice_management_mobile.core.validators.PasswordValidator
import com.example.cue_practice_management_mobile.domain.models.User
import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginFormState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val generalError: String? = null
)

@HiltViewModel
class LoginFormViewModel @Inject constructor(
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator,
    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _state = MutableStateFlow(LoginFormState())
    val state: StateFlow<LoginFormState> = _state

    fun onEmailChanged(email: String) {
        val result = emailValidator.validate(email)
        _state.update { it.copy(email = email, emailError = result.errorMessage) }
    }

    fun onPasswordChanged(password: String) {
        val result = passwordValidator.validate(password)
        _state.update { it.copy(password = password, passwordError = result.errorMessage) }
    }

    fun validateForm(): Boolean {
        val emailResult = emailValidator.validate(_state.value.email)

        _state.update {
            it.copy(
                emailError = emailResult.errorMessage,
            )
        }

        return emailResult.successful
    }

    fun login(onSuccess: (User?) -> Unit) {
        if (!validateForm()) return

        _state.update { it.copy(isLoading = true, generalError = null) }
        Log.d("LoginFormViewModel", "Starting login process...")

        viewModelScope.launch {
            try {
                Log.d("LoginFormViewModel", "Attempting login with email: ${_state.value.email}")
                val response = authRepository.login(
                    LoginRequest(
                        email = _state.value.email,
                        password = _state.value.password
                    )
                )
                Log.d("LoginFormViewModel", "Login response: $response")
                sessionManager.handleLogin(response)
                Log.d("LoginFormViewModel", "Login successful, updating session ${sessionManager.user}")
                val user = sessionManager.user.value;
                onSuccess(user)
            } catch (e: Exception) {
                Log.e("LoginFormViewModel", "Login failed", e)
                _state.update { it.copy(generalError = "Credenciales inválidas o error del servidor") }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
