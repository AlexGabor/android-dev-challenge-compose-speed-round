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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.coil.CoilImage

data class CardItem(
    val image: String,
    @StringRes val text: Int
)

val cardItems = listOf(
    CardItem("https://images.pexels.com/photos/2533712/pexels-photo-2533712.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.card1),
    CardItem("https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260", R.string.card2),
    CardItem("https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.card3),
    CardItem("https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260", R.string.card4),
    CardItem("https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260", R.string.card5),
    CardItem("https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", R.string.card6),
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
    val text = stringResource(id = item.text)

    Surface(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp),
        shape = MaterialTheme.shapes.small,
    ) {
        Row {
            CoilImage(
                data = item.image,
                contentDescription = text,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp),
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
