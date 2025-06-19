package com.example.cue_practice_management_mobile.core.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppNavigationItem(
    icon: ImageVector,
    contentDescription: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val iconSize = if (isSelected) 28.dp else 24.dp
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Transparent
    val iconTint = if (isSelected) MaterialTheme.colorScheme.onSurface else Color.White
    val shape = RoundedCornerShape(16.dp)

    Surface(
        modifier = Modifier
            .height(56.dp)
            .widthIn(min = 56.dp)
            .clip(shape)
            .clickable(onClick = onClick),
        color = backgroundColor,
        tonalElevation = if (isSelected) 4.dp else 0.dp,
        shape = shape
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ){
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(iconSize),
                tint = iconTint
            )
        }
    }
}