package com.alyxia.gdos_portal_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
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
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        val emailState = remember { mutableStateOf(TextFieldValue())}
                        val passState = remember { mutableStateOf(TextFieldValue())}
                        TextField(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            label = { Text("Email") },
                            value = emailState.value,
                            onValueChange = { emailState.value = it })
                        TextField(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            label = { Text("Password") },
                            value = passState.value,
                            onValueChange = { passState.value = it })
                        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "The email field has this text: ${emailState.value.text}")
                        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "The password field has this text: ${passState.value.text}")
                    }
                }
            }
        }
    }
}
