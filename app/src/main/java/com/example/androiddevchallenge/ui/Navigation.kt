package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screen.Login
import com.example.androiddevchallenge.ui.screen.Welcome
import com.example.androiddevchallenge.ui.screen.main.MainNavigator

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { Welcome(navController) }
        composable("login") { Login(navController) }
        composable("main") { MainNavigator() }
    }
}