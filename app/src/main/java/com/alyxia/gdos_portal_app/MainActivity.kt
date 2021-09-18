package com.alyxia.gdos_portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alyxia.gdos_portal_app.ui.theme.GDOSPortalAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDOSPortalAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "loginscreen") {
                        composable("loginscreen") { LoginScreen(navController) }
                        composable("main") { Main(navController) }
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun LoginScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column {
            Text(
                modifier = Modifier
                    .padding(top = 120.dp)
                    .align(Alignment.CenterHorizontally), fontSize = 25.sp, text = "Login to"
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 25.sp,
                text = "Gilde DevOps Portal"
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 160.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            var emailState by remember { mutableStateOf(TextFieldValue()) }
            var passState by remember { mutableStateOf(TextFieldValue()) }
            var isErrored by remember { mutableStateOf(false) }
            val pattern = "^[^@]+@[^@]+\\.[^@]+\$".toRegex()

            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Email") },
                value = emailState,
                isError = isErrored,
                onValueChange = {
                    emailState = it
                    isErrored = !emailState.text.contains(pattern)
                }
            )
            AnimatedVisibility(visible = isErrored) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        fontSize = 10.sp,
                        color = MaterialTheme.colors.error,
                        text = "Invalid Email!"
                    )
                }
            }
            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Password") },
                value = passState,
                onValueChange = { passState = it }
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                onClick = {
                    if (emailState.text.isNotEmpty() && !isErrored && passState.text.isNotEmpty()) {
                        navController.navigate("main")
                    }
                }
            ) {
                Text("Login")
            }
        }
    }
}

@Composable
fun Main(navController: NavController) {
    Column {
        Text("test")
    }
}