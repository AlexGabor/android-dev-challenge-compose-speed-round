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

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.modifiers.firstBaselineToTop

data class ImageItem(
    @DrawableRes val image: Int,
    @StringRes val text: Int
)

val imageItems = listOf(
    ImageItem(R.drawable.nightly, R.string.body1),
    ImageItem(R.drawable.inversions, R.string.body2),
    ImageItem(R.drawable.quick_yoga, R.string.body3),
    ImageItem(R.drawable.streching, R.string.body4),
    ImageItem(R.drawable.tabata, R.string.body5),
    ImageItem(R.drawable.hiit, R.string.body6),
)

val alignYourMindItems = listOf(
    ImageItem(R.drawable.prenatal, R.string.mind1),
    ImageItem(R.drawable.meditate, R.string.mind2),
    ImageItem(R.drawable.with_kids, R.string.mind3),
    ImageItem(R.drawable.aromatherapy, R.string.mind4),
    ImageItem(R.drawable.on_the_go, R.string.mind5),
    ImageItem(R.drawable.with_pets, R.string.mind6),
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
    val image = painterResource(id = item.image)
    val text = stringResource(id = item.text)

    Column(Modifier.padding(end = if (last) 0.dp else 8.dp).width(88.dp)) {
        Image(
            painter = image,
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).size(88.dp)
        )
        Text(
            text = text, style = MaterialTheme.typography.h3,
            modifier = Modifier.firstBaselineToTop(24.dp).align(Alignment.CenterHorizontally)
        )
    }
}
