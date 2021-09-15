package com.alyxia.gdos_portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alyxia.gdos_portal_app.ui.theme.GDOSPortalAppTheme

class MainActivity : ComponentActivity() {
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

@Composable
fun LoginScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column {
            Text(
                modifier = Modifier
                    .padding(top = 100.dp)
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
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val emailState = remember { mutableStateOf(TextFieldValue()) }
            val passState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Email") },
                value = emailState.value,
                onValueChange = { emailState.value = it }
            )
            TextField(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                label = { Text("Password") },
                value = passState.value,
                onValueChange = { passState.value = it }
            )
            Button(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp), onClick = { navController.navigate("main") }) {
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