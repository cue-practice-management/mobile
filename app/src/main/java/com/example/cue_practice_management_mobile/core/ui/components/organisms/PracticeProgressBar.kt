package com.example.cue_practice_management_mobile.core.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.molecules.ProgressStep
import com.example.cue_practice_management_mobile.core.ui.constants.PracticeProgressState

@Composable
fun PracticeProgressBar(state: PracticeProgressState) {
    val startChecked = true
    val deliveryChecked = state >= PracticeProgressState.DELIVERING
    val approvedChecked = state == PracticeProgressState.APPROVED

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        ProgressStep("inicio", startChecked)
        Box(modifier = Modifier.weight(1f).height(2.dp).background(if (deliveryChecked) Color(0xFF28A745) else Color.LightGray))
        ProgressStep("entregables", deliveryChecked)
        Box(modifier = Modifier.weight(1f).height(2.dp).background(if (approvedChecked) Color(0xFF28A745) else Color.LightGray))
        ProgressStep("aprobado", approvedChecked)
    }
}