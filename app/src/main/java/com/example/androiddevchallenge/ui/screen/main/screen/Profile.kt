package com.example.androiddevchallenge.ui.screen.main.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Composable
fun Profile(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
        }
    }
}