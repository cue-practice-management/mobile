package com.example.cue_practice_management_mobile.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class ButtonVariant {
    Primary, Outline, Danger
}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary
) {
    val (containerColor, contentColor) = when (variant) {
        ButtonVariant.Primary -> MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.onPrimary
        ButtonVariant.Outline -> Color.Transparent to MaterialTheme.colorScheme.primary
        ButtonVariant.Danger -> MaterialTheme.colorScheme.error to MaterialTheme.colorScheme.onError
    }

    val buttonColors = when (variant) {
        ButtonVariant.Outline -> ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.1f),
            disabledContentColor = contentColor.copy(alpha = 0.3f)
        )
        else -> ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.3f),
            disabledContentColor = contentColor.copy(alpha = 0.3f)
        )
    }

    val buttonContent: @Composable () -> Unit = {
        AppButtonContent(text = text, isLoading = isLoading, contentColor = contentColor)
    }

    when (variant) {
        ButtonVariant.Outline -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !isLoading,
            shape = MaterialTheme.shapes.medium,
            colors = buttonColors,
            border = ButtonDefaults.outlinedButtonBorder
        ) { buttonContent() }

        else -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !isLoading,
            shape = MaterialTheme.shapes.medium,
            colors = buttonColors,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
        ) { buttonContent() }
    }
}

@Composable
private fun AppButtonContent(text: String, isLoading: Boolean, contentColor: Color) {
    Box(contentAlignment = Alignment.Center) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor,
                strokeWidth = 2.dp,
                modifier = Modifier.size(18.dp)
            )
        } else {
            Text(text = text, style = MaterialTheme.typography.labelLarge)
        }
    }
}