package com.example.androiddevchallenge.ui.screen.main.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppTextField
import com.example.androiddevchallenge.ui.components.type.H2
import com.example.androiddevchallenge.ui.modifiers.firstBaselineToTop
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun Home(navController: NavHostController) {
    var search by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                AppTextField(
                    value = search, onValueChange = {
                        search = it
                    },
                    leadingIcon = {
                        Image(
                            painterResource(id = R.drawable.ic_search),
                            null,
                            colorFilter = ColorFilter.tint(
                                LocalContentColor.current
                            )
                        )
                    },
                    placeholderText = "Search",
                    modifier = Modifier
                        .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                        .statusBarsPadding()
                )
            }

            item {
                H2(
                    text = "Favourite Collections",
                    modifier = Modifier
                        .firstBaselineToTop(40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                CardRow(Modifier.padding(top = 8.dp))
            }
            item {
                H2(
                    text = "Align your body",
                    modifier = Modifier
                        .firstBaselineToTop(40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                ImageList(Modifier.padding(top = 8.dp))
            }
            item {
                H2(
                    text = "Align your mind",
                    modifier = Modifier
                        .firstBaselineToTop(40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                ImageList(Modifier.padding(top = 8.dp), items = alignYourMindItems)
            }
        }
    }
}