package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppButton
import com.example.androiddevchallenge.ui.components.AppButtonText

@Composable
fun Welcome(navController: NavHostController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.bg_welcome),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_logo),
                    contentDescription = stringResource(R.string.logo_content_description),
                )

                AppButton(modifier = Modifier.padding(top = 32.dp),
                    onClick = { /*TODO*/ }) {
                    AppButtonText(stringResource(R.string.sign_up))
                }
                AppButton(modifier = Modifier.padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    onClick = { navController.navigate("login") }) {
                    AppButtonText(stringResource(R.string.log_in))
                }
            }

        }
    }
}
