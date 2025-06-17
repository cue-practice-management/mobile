package com.example.cue_practice_management_mobile.features.auth.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cue_practice_management_mobile.core.ui.components.AppButton
import com.example.cue_practice_management_mobile.core.ui.components.InputText
import com.example.cue_practice_management_mobile.features.auth.viewmodels.LoginFormViewModel

@Composable
fun LoginForm(
    onLoginSuccess: () -> Unit = {}
) {
    val viewModel: LoginFormViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InputText(
            value = state.email,
            onValueChange = viewModel::onEmailChanged,
            placeholder = "Correo Electrónico",
            isError = state.emailError != null,
            errorMessage = state.emailError
        )

        InputText(
            value = state.password,
            onValueChange = viewModel::onPasswordChanged,
            placeholder = "Contraseña",
            visualTransformation = PasswordVisualTransformation()
        )

        AppButton(
            modifier = Modifier.align(Alignment.End),
            text = "Iniciar Sesión",
            onClick = {
                if (viewModel.validateForm()) {
                    viewModel.login(onSuccess = onLoginSuccess)
                }
            },
            isLoading = state.isLoading,
            enabled = !state.isLoading
        )
    }
}