package com.example.cue_practice_management_mobile.core.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Check
import com.composables.icons.lucide.Lucide

@Composable
fun AppProgressDot(checked: Boolean) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(
                color = if (checked) Color(0xFF28A745) else Color.White,
                shape = CircleShape
            )
            .border(2.dp, Color(0xFF28A745), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Lucide.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}