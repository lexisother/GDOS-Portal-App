package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun Main(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Dashboard")
                },
                backgroundColor = Color(0xFF002F5D)
            )
        },
        content = {
            Text("Test")
        }
    )
}
