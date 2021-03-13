/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:JvmName("MainKt")

package com.example.androiddevchallenge.ui.screen.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppBottomNavigation
import com.example.androiddevchallenge.ui.screen.main.screen.Profile
import com.example.androiddevchallenge.ui.screen.main.screen.home.Home
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.Locale

val items = listOf(
    HomeScreen.Home,
    HomeScreen.Profile,
)

sealed class HomeScreen(val route: String, @DrawableRes val icon: Int, @StringRes val name: Int) {
    object Home : HomeScreen("home", R.drawable.ic_spa, R.string.screen_home)
    object Profile :
        HomeScreen("profile", R.drawable.ic_profile, R.string.screen_profile)
}

@Composable
fun MainNavigator() {
    val navController = rememberNavController()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = HomeScreen.Home.route) {
            composable(HomeScreen.Home.route) { Home(navController) }
            composable(HomeScreen.Profile.route) { Profile(navController) }
        }

        AppBottomNavigation(Modifier.align(Alignment.BottomCenter)) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
            items.forEach { screen ->
                val screenName = stringResource(screen.name)
                BottomNavigationItem(
                    icon = {
                        Image(
                            modifier = Modifier.requiredSize(18.dp),
                            painter = painterResource(screen.icon),
                            contentDescription = screenName,
                            colorFilter = ColorFilter.tint(LocalContentColor.current)
                        )
                    },
                    label = {
                        Text(
                            screenName.toUpperCase(Locale.getDefault()),
                            style = MaterialTheme.typography.caption
                        )
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
                    }
                )
            }
        }

        Button(
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryContent),
            onClick = {},
            modifier = Modifier
                .navigationBarsPadding()
                .size(56.dp)
                .align(Alignment.BottomCenter)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    layout(placeable.width, placeable.height) {
                        // Where the composable gets placed
                        placeable.place(0, -placeable.height / 2)
                    }
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "play",
                colorFilter = ColorFilter.tint(
                    LocalContentColor.current
                )
            )
        }
    }
}

val Colors.primaryContent: Color get() = if (isLight) primary else onBackground
