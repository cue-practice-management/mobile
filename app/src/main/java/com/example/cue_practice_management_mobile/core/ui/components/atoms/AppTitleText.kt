package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun AppTitleText(
    text: String,
    modifier: Modifier = Modifier.Companion,
    color: Color = MaterialTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
    size: AppTitleTextSize = AppTitleTextSize.Large
) {
    val textSize = when (size) {
        AppTitleTextSize.Small -> MaterialTheme.typography.titleSmall
        AppTitleTextSize.Medium -> MaterialTheme.typography.titleMedium
        AppTitleTextSize.Large -> MaterialTheme.typography.titleLarge
        AppTitleTextSize.ExtraLarge -> MaterialTheme.typography.headlineLarge
        AppTitleTextSize.ExtraExtraLarge -> MaterialTheme.typography.headlineLarge
    }

    Text(
        text = text,
        style = textSize,
        color = color,
        modifier = modifier,
        textAlign = textAlign
    )
}


enum class AppTitleTextSize(val size: androidx.compose.ui.unit.TextUnit) {
    Small(TextUnit.Unspecified),
    Medium(TextUnit.Unspecified),
    Large(TextUnit.Unspecified),
    ExtraLarge(TextUnit.Unspecified),
    ExtraExtraLarge(TextUnit.Unspecified)
}