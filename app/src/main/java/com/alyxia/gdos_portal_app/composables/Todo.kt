package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.alyxia.gdos_portal_app.structures.TodoDB
import com.alyxia.gdos_portal_app.structures.TodoDBItem

@ExperimentalComposeUiApi
@Composable
fun Todo(navController: NavController, todoItems: TodoDB?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Todo")
                },
                backgroundColor = Color(0xFF002F5D)
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                todoItems?.let { item ->
                    items(item.entries.map { it.value }) { mod ->
                        TodoItem(mod)
                    }
                }
            }
        }
    )
}

@ExperimentalComposeUiApi
@Composable
fun TodoItem(item: TodoDBItem) {
    var isDialogVisible by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isDialogVisible = true },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(item.name)
            Text(item.content)
        }
    }

    if (isDialogVisible) {
        Dialog(
            onDismissRequest = { isDialogVisible = false },
            properties = DialogProperties(usePlatformDefaultWidth = false),
            content = {
                Card(
                    modifier = Modifier
                        .padding(30.dp)
                        .background(Color(0xFF2d2d2d))
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            fontSize = 20.sp,
                            text = item.name
                        )
                        Text(item.content)
                    }

                }
            }
        )
    }
}