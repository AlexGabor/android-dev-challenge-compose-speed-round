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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

data class CardItem(
    @DrawableRes val image: Int,
    @StringRes val text: Int
)

val cardItems = listOf(
    CardItem(R.drawable.overwhelmed, R.string.card1),
    CardItem(R.drawable.stress, R.string.card2),
    CardItem(R.drawable.nature_med, R.string.card3),
    CardItem(R.drawable.short_mantras, R.string.card4),
    CardItem(R.drawable.self_massage, R.string.card5),
    CardItem(R.drawable.overwhelmed, R.string.card6),
)

@Composable
fun CardRow(
    modifier: Modifier = Modifier,
    items: List<CardItem> = cardItems
) {

    val gridItems: List<Pair<CardItem, CardItem?>> = (0 until (items.size + 1) / 2).map { index ->
        items[index] to items.getOrNull(index + items.size / 2)
    }

    LazyRow(
        modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        content = {
            itemsIndexed(gridItems) { index, itemPair ->
                val (top, bottom) = itemPair
                Column(Modifier.padding(end = if (index == gridItems.size - 1) 0.dp else 8.dp)) {
                    Card(top)
                    Spacer(modifier = Modifier.size(8.dp))
                    bottom?.let { Card(bottom) }
                }
            }
        }
    )
}

@Composable
fun Card(item: CardItem) {
    val image = painterResource(id = item.image)
    val text = stringResource(id = item.text)

    Surface(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp),
        shape = MaterialTheme.shapes.small,
    ) {
        Row {
            Image(
                painter = image,
                contentDescription = text,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = text, style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}
