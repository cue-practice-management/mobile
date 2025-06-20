package com.example.cue_practice_management_mobile.core.ui.components.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cue_practice_management_mobile.core.navigation.NAV_ITEMS
import com.example.cue_practice_management_mobile.core.navigation.Routes
import com.example.cue_practice_management_mobile.core.ui.components.organisms.AppHeader
import com.example.cue_practice_management_mobile.core.ui.components.organisms.AppBottomNavBar
import com.example.cue_practice_management_mobile.core.viewmodels.UserSessionViewModel
import com.example.cue_practice_management_mobile.domain.models.User

@Composable
fun AppBaseScreenLayout(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    content: @Composable (User) -> Unit
) {
    val userSessionViewModel: UserSessionViewModel = hiltViewModel()
    val userState = userSessionViewModel.user.collectAsState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: NAV_ITEMS.HOME.route

    LaunchedEffect(userState.value) {
        if (userState.value == null) {
            navController.navigate(Routes.LOGIN) {
                popUpTo(0)
            }
        }
    }

    userState.value?.let { user ->
        Box(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp)
            ) {
                AppHeader(
                    user = user,
                    onLogout = { userSessionViewModel.logout() }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    content(user)
                }
            }

            // Bottom navigation bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .align(Alignment.BottomCenter)
            ) {
                AppBottomNavBar(
                    selectedRoute = currentRoute,
                    onItemSelected = { route -> navController.navigate(route) }
                )
            }
        }
    } ?: run {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}