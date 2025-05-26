package com.example.cue_practice_management_mobile.features.auth.view_models

import androidx.lifecycle.ViewModel
import com.example.cue_practice_management_mobile.core.validators.EmailValidator
import com.example.cue_practice_management_mobile.core.validators.PasswordValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class LoginFormState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null
)

@HiltViewModel
class LoginFormViewModel @Inject constructor(
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator
) :ViewModel() {

    private val _state = MutableStateFlow(LoginFormState())
    val state: StateFlow<LoginFormState> = _state

    fun onEmailChanged(email: String) {
        val emailResult = emailValidator.validate(email)
        _state.update {
            it.copy(
                email = email,
                emailError = emailResult.errorMessage
            )
        }
    }

    fun onPasswordChanged(password: String) {
        val passwordResult = passwordValidator.validate(password)
        _state.update {
            it.copy(
                password = password,
                passwordError = passwordResult.errorMessage
            )
        }
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
}
