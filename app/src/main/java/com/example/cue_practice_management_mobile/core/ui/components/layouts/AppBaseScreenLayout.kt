package com.example.cue_practice_management_mobile.core.ui.components.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cue_practice_management_mobile.core.ui.components.organisms.AppHeader
import com.example.cue_practice_management_mobile.core.ui.components.organisms.AppBottomNavBar
import com.example.cue_practice_management_mobile.domain.models.User

@Composable
fun AppBaseScreenLayout(
    user: User,
    selectedRoute: String,
    onLogout: () -> Unit,
    onNavItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 72.dp)
        ) {
            AppHeader(
                user = user,
                onLogout = onLogout
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                content()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
        ) {
            AppBottomNavBar(
                selectedRoute = selectedRoute,
                onItemSelected = onNavItemSelected
            )
        }
    }
}