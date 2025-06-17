package com.example.cue_practice_management_mobile.features.auth.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cue_practice_management_mobile.core.validators.EmailValidator
import com.example.cue_practice_management_mobile.core.validators.PasswordValidator
import com.example.cue_practice_management_mobile.features.auth.models.LoginRequest
import com.example.cue_practice_management_mobile.features.auth.repositories.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val authRepository: AuthRepository
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
        val passwordResult = passwordValidator.validate(_state.value.password)

        _state.update {
            it.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
        }

        return emailResult.successful && passwordResult.successful
    }

    fun login(onSuccess: () -> Unit) {
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
                onSuccess()
            } catch (e: Exception) {
                Log.e("LoginFormViewModel", "Login failed", e)
                _state.update { it.copy(generalError = "Credenciales inválidas o error del servidor") }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
