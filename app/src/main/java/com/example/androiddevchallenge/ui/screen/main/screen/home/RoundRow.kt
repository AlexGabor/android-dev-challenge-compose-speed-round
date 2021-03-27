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
package com.example.androiddevchallenge.ui.screen.main.screen.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.modifiers.firstBaselineToTop
import dev.chrisbanes.accompanist.coil.CoilImage

data class ImageItem(
    val image: String,
    @StringRes val text: Int
)

val imageItems = listOf(
    ImageItem("https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body1),
    ImageItem("https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body2),
    ImageItem("https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body3),
    ImageItem("https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body4),
    ImageItem("https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body5),
    ImageItem("https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.body6),
)

val alignYourMindItems = listOf(
    ImageItem("https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.mind1),
    ImageItem("https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?cs=srgb&dl=pexels-valeria-ushakova-3094230.jpg&fm=jpg", R.string.mind2),
    ImageItem("https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.mind3),
    ImageItem("https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.mind4),
    ImageItem("https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.mind5),
    ImageItem("https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.mind6),
)

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    items: List<ImageItem> = imageItems
) {
    LazyRow(
        modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        content = {
            itemsIndexed(items) { index, item ->
                Item(item = item, index == items.size - 1)
            }
        }
    )
}

@Composable
fun Item(item: ImageItem, last: Boolean) {
    val text = stringResource(id = item.text)

    Column {
        CoilImage(
            data = item.image,
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(end = if (last) 0.dp else 8.dp).clip(CircleShape).size(88.dp),
        )
        Text(
            text = text, style = MaterialTheme.typography.h3,
            modifier = Modifier.firstBaselineToTop(24.dp).align(Alignment.CenterHorizontally)
        )
    }
}
