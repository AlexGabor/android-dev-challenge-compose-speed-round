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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.AppButton
import com.example.androiddevchallenge.ui.components.AppButtonText
import com.example.androiddevchallenge.ui.components.AppTextField
import com.example.androiddevchallenge.ui.components.type.H1
import com.example.androiddevchallenge.ui.modifiers.firstBaselineToTop
import java.util.Locale

@Composable
fun Login(navController: NavHostController) {
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.bg_login),
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
                H1(
                    Modifier.padding(bottom = 32.dp),
                    stringResource(R.string.log_in).toUpperCase(Locale.getDefault())
                )

                AppTextField(
                    value = emailAddress,
                    onValueChange = {
                        emailAddress = it
                    },
                    placeholderText = "Email Address",
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                AppTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    placeholderText = "Password",
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                AppButton(
                    onClick = { navController.navigate("main") }
                ) {
                    AppButtonText(stringResource(R.string.log_in))
                }

                Text(
                    text =
                    AnnotatedString("Don't have an account? ") +
                        AnnotatedString(
                            "Sign Up",
                            spanStyle = SpanStyle(textDecoration = TextDecoration.Underline)
                        ),
                    modifier = Modifier.firstBaselineToTop(32.dp)
                )
            }
        }
    }
}
