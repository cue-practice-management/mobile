package com.example.cue_practice_management_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cue_practice_management_mobile.core.navigation.AppNavHost
import com.example.cue_practice_management_mobile.core.session.SessionObserver
import com.example.cue_practice_management_mobile.core.ui.theme.CuepracticemanagementmobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CuepracticemanagementmobileTheme {
                val navController = rememberNavController()

                SessionObserver(navController = navController)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .statusBarsPadding()
                            .fillMaxSize()
                    ) {
                        AppNavHost(navController = navController)
                    }
                }
            }
        }
    }
}
