package com.alyxia.gdos_portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alyxia.gdos_portal_app.composables.LoginScreen
import com.alyxia.gdos_portal_app.composables.Main
import com.alyxia.gdos_portal_app.ui.theme.GDOSPortalAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDOSPortalAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val systemUiController = rememberSystemUiController()
                    val useDarkIcons = MaterialTheme.colors.isLight
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            color = Color(0xFF002F5D),
                            darkIcons = useDarkIcons
                        )
                    }

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("loginscreen") { LoginScreen(navController) }
                        composable("main") { Main(navController) }
                    }
                }
            }
        }
    }
}

