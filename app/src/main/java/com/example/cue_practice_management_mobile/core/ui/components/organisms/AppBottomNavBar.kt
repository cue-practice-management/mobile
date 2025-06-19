package com.example.cue_practice_management_mobile.core.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.navigation.NAV_ITEMS
import com.example.cue_practice_management_mobile.core.ui.components.molecules.AppNavigationItem

@Composable
fun AppBottomNavBar(
    selectedRoute: String,
    onItemSelected: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            NAV_ITEMS.BOTTOM_NAV_ITEMS.forEach { item ->
                AppNavigationItem(
                    icon = item.icon,
                    contentDescription = item.label,
                    isSelected = selectedRoute == item.route,
                    onClick = { onItemSelected(item.route) }
                )
            }
        }
    }
}