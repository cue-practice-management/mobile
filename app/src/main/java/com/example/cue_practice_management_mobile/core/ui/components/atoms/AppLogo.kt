package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.R

enum class AppLogoSize(val dp: Dp) {
    Small(48.dp),
    Medium(96.dp),
    Large(144.dp),
    ExtraLarge(192.dp),
    ExtraExtraLarge(384.dp)
}

enum class AppLogoVariant {
    Original,
    White
}

@Composable
fun AppLogo(
    modifier: Modifier = Modifier.Companion,
    size: AppLogoSize = AppLogoSize.Medium,
    variant: AppLogoVariant? = null,
    contentDescription: String? = "App Logo",
    alpha: Float = 1f
) {
    val isDark = isSystemInDarkTheme()
    val resolvedVariant = variant ?: if (isDark) AppLogoVariant.White else AppLogoVariant.Original

    @DrawableRes val imageRes = when (resolvedVariant) {
        AppLogoVariant.Original -> R.drawable.logo
        AppLogoVariant.White -> R.drawable.logo_white
    }

    Image(
        painter = painterResource(id = imageRes),
        contentDescription = contentDescription,
        contentScale = ContentScale.Companion.Fit,
        modifier = modifier
            .size(size.dp)
            .alpha(alpha)
    )
}