package com.alyxia.gdos_portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alyxia.gdos_portal_app.composables.LoginScreen
import com.alyxia.gdos_portal_app.composables.Main
import com.alyxia.gdos_portal_app.composables.Todo
import com.alyxia.gdos_portal_app.structures.UserDB
import com.alyxia.gdos_portal_app.ui.theme.GDOSPortalAppTheme
import com.beust.klaxon.Klaxon
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : ComponentActivity() {
    private val client = OkHttpClient()

    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
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

                    val coroutineScope = rememberCoroutineScope()
                    var result by remember { mutableStateOf<UserDB?>(null) }
                    coroutineScope.launch(Dispatchers.IO) {
                        val builtReq =
                            Request.Builder().url("https://nova-vps.ml/~alyxia/api/accounts.json")
                                .build()
                        val request = client.newCall(builtReq).execute()?.body()?.string()
                        println(request)
                        if (request != null) {
                            result = Klaxon().parse<UserDB>(request)
                        }
                    }

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "loginscreen") {
                        composable("loginscreen") { result?.let { it1 ->
                            LoginScreen(navController,
                                it1
                            )
                        } }
                        composable("main") { Main(navController, result!!.users[0]) }
                        composable("todo") { Todo(navController, result!!.users[0].todo) }
                    }
                }
            }
        }
    }
}
