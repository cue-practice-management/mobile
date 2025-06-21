package com.example.cue_practice_management_mobile.core.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cue_practice_management_mobile.core.navigation.NAV_ITEMS
import com.example.cue_practice_management_mobile.core.ui.components.molecules.AppNavigationItem
import com.example.cue_practice_management_mobile.core.viewmodels.UserSessionViewModel
import com.example.cue_practice_management_mobile.domain.enums.UserRole

@Composable
fun AppBottomNavBar(
    selectedRoute: String,
    onItemSelected: (String) -> Unit,
) {
    val userSessionViewModel: UserSessionViewModel = hiltViewModel()
    val userState = userSessionViewModel.user.collectAsState()

    val navItems = when (userState.value?.role) {
        UserRole.STUDENT -> NAV_ITEMS.STUDENT_BOTTOM_NAV_ITEMS
        UserRole.PROFESSOR -> NAV_ITEMS.PROFESSOR_BOTTOM_NAV_ITEMS
        else -> NAV_ITEMS.STUDENT_BOTTOM_NAV_ITEMS
    }

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
            navItems.forEach { item ->
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