package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = if (isSystemInDarkTheme()) 0.dp else 8.dp,
    content: @Composable RowScope.() -> Unit
) {
//    Surface(
//        color = backgroundColor,
//        contentColor = contentColor,
//        elevation = elevation,
//        modifier = modifier
//    ) {
//        Surface(
//            color = backgroundColor,
//            contentColor = contentColor,
//            modifier = Modifier.navigationBarsPadding()
//        ) {
    BottomNavigation(
        modifier = modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .height(56.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        content = content
    )
//        }
//    }
}