package com.alyxia.gdos_portal_app.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alyxia.gdos_portal_app.ui.theme.GildeDarkBlue
import com.alyxia.gdos_portal_app.ui.theme.GildeGrey
import com.alyxia.gdos_portal_app.ui.theme.GildePink

@ExperimentalFoundationApi
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
            Column {
                Image(
                    painter = painterResource(id = com.alyxia.gdos_portal_app.R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.padding(40.dp)
                )
                LazyVerticalGrid(
                    cells = GridCells.Fixed(4),
                    content = {
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.clock,
                                desc = "Clock",
                                bgColor = GildeGrey
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.calendar,
                                desc = "Calendar",
                                bgColor = GildeDarkBlue
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.note_text,
                                desc = "Notes",
                                bgColor = GildeDarkBlue
                            )
                        }
                        item {
                            IconCard(
                                drawable = com.alyxia.gdos_portal_app.R.drawable.bell,
                                desc = "Notifications",
                                bgColor = GildePink
                            )
                        }
                    }
                )
            }
        }
    )
}

@Composable
fun IconCard(drawable: Int, desc: String, bgColor: Color) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .height(100.dp)
            .fillMaxWidth(),
        backgroundColor = bgColor
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = desc,
            contentScale = ContentScale.FillHeight
        )
    }
}