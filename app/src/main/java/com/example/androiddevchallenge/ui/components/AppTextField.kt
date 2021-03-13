package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholderText: String = "",
) {
    TextField(
        value,
        onValueChange,
        modifier
            .fillMaxWidth()
            .height(56.dp),
        leadingIcon = leadingIcon,
        visualTransformation = visualTransformation,
        placeholder = {
            Placeholder(text = placeholderText)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
        )
    )
}

@Composable
fun Placeholder(text: String) {
    Box(Modifier.fillMaxSize()) {
        Text(
            text, style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.CenterStart)
        )
    }
}