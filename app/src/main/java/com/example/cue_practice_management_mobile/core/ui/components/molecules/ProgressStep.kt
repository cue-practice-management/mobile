package com.example.cue_practice_management_mobile.core.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppLabelText
import com.example.cue_practice_management_mobile.core.ui.components.atoms.AppProgressDot

@Composable
fun ProgressStep(label: String, checked: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AppProgressDot(checked = checked)
        Spacer(modifier = Modifier.height(4.dp))
        AppLabelText(label)
    }
}
