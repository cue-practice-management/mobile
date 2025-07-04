package com.example.cue_practice_management_mobile.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = White,
    secondary = Secondary,
    onSecondary = White,
    background = Light,
    onBackground = Dark,
    surface = White,
    onSurface = Dark,
    error = Error,
    onError = White
)

val DarkColorScheme = darkColorScheme(
    primary = PrimaryLight,
    onPrimary = Dark,
    secondary = SecondaryLight,
    onSecondary = Dark,
    background = Dark,
    onBackground = Light,
    surface = GrayDark,
    onSurface = White,
    error = ErrorLight,
    onError = Dark
)

@Composable
fun CuepracticemanagementmobileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}