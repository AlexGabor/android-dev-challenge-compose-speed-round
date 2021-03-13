package com.example.androiddevchallenge.ui.components.type

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.*

@Composable
fun H1(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h1,
        modifier = modifier
    )
}

@Composable
fun H2(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        modifier = modifier
    )
}