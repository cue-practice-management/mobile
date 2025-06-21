package com.example.cue_practice_management_mobile.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cue_practice_management_mobile.features.auth.screens.LoginScreen
import com.example.cue_practice_management_mobile.features.practice_process.screen.PracticeProcessDetailScreen
import com.example.cue_practice_management_mobile.features.professor.screens.ProfessorHomeScreen
import com.example.cue_practice_management_mobile.features.splash.screens.SplashScreen
import com.example.cue_practice_management_mobile.features.student.screens.StudentHomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Routes.SPLASH
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.LOGIN) {
            LoginScreen(
                navController = navController
            )
        }

        composable(Routes.SPLASH) {
            SplashScreen(navController = navController)
        }

        composable(Routes.STUDENT_HOME) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                StudentHomeScreen(navController = navController)
            }
        }

        composable(Routes.PROFESSOR_HOME) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                ProfessorHomeScreen(navController = navController)
            }
        }

        composable("${Routes.PRACTICE_DETAIL}/{processId}") { backStackEntry ->
            val processId = backStackEntry.arguments?.getString("processId")
            PracticeProcessDetailScreen(
                processId = processId ?: "",
                navController = navController
            )
        }
    }
}
