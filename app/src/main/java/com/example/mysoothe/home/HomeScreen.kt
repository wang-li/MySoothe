package com.example.mysoothe.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.R
import com.example.mysoothe.composable.SootheTextField
import com.example.mysoothe.data.ALIGN_YOUR_BODY_ITEMS
import com.example.mysoothe.data.ALIGN_YOUR_MIND_ITEMS
import com.example.mysoothe.data.COLLECTIONS_ITEMS
import com.example.mysoothe.data.CollectionModel
import com.example.mysoothe.ui.theme.MySootheTheme
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.toPaddingValues
import java.util.*

@Composable
fun HomeScreen() {
    ProvideWindowInsets {
        Surface(
            Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                bottomBar = { HomeBottomBar() },
            ) { paddingValues ->
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(bottom = paddingValues.calculateBottomPadding() - 27.dp),
                    contentPadding = LocalWindowInsets.current
                        .systemBars
                        .toPaddingValues()
                ) {
                    item("search") {
                        SootheTextField(
                            label = "Search",
                            iconRes = R.drawable.ic_baseline_search_24,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }

                    item("collectionsTitle") { SectionTitle("Favorite collections") }
                    item("collectionsItems") { CollectionsRow(COLLECTIONS_ITEMS) }

                    item("alignYourBodyTitle") { SectionTitle("Align your body") }
                    item("alignYourBodyItems") { RoundItemsRow(ALIGN_YOUR_BODY_ITEMS) }

                    item("alignYourMindTitle") { SectionTitle("Align your mind") }
                    item("alignYourMindItems") { RoundItemsRow(ALIGN_YOUR_MIND_ITEMS) }
                    item("spacer") { Spacer(modifier = Modifier.height(8.dp)) }
                }
            }
        }
    }
}

@Composable
fun HomeBottomBar() {
    val bottomInset = LocalWindowInsets.current
        .systemBars
        .toPaddingValues()
        .calculateBottomPadding()

    Box(Modifier.height(81.dp + bottomInset)) {
        BottomNavigation(
            Modifier
                .height(54.dp + bottomInset)
                .align(Alignment.BottomCenter),
            backgroundColor = MaterialTheme.colors.background
        ) {
            BottomNavigationItem(
                modifier = Modifier.padding(bottom = bottomInset),
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_spa_24),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                },
                label = {
                    Text(
                        "Home".toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.caption
                    )
                }
            )
            BottomNavigationItem(
                modifier = Modifier.padding(bottom = bottomInset),
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_account_circle_24),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                },
                label = {
                    Text(
                        "Profile".toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.caption
                    )
                }
            )
        }

        HomeFloatingActionButton(Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun HomeFloatingActionButton(modifier: Modifier = Modifier) {
    FloatingActionButton(
        modifier = modifier,
        onClick = {},
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_baseline_play_arrow_24),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        title.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h2,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 40.dp)
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun CollectionsRow(items: List<Pair<CollectionModel, CollectionModel>>) {
    LazyRow(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { CollectionItem(it) }
    }
}

@Composable
fun CollectionItem(itemData: Pair<CollectionModel, CollectionModel>) {
    Column {
        CollectionSubItem(itemData.first)
        Spacer(modifier = Modifier.size(8.dp))
        CollectionSubItem(itemData.second)
    }
}

@Composable
fun CollectionSubItem(subItemData: CollectionModel) {
    val size = 56

    Row(
        Modifier
            .size(width = 192.dp, height = size.dp)
            .background(
                color = MaterialTheme.colors.surface,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Image(
            painter = rememberCoilPainter(
                "${subItemData.url}?auto=compress&cs=tinysrgb&dpr=3&h=$size&w=$size",
                fadeIn = true
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(size.dp)
                .clip(
                    MaterialTheme.shapes.small.copy(
                        topEnd = CornerSize(0.dp),
                        bottomEnd = CornerSize(0.dp)
                    )
                )
        )
        Text(
            subItemData.name,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun RoundItemsRow(items: List<CollectionModel>) {
    LazyRow(
        Modifier.padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { RoundItem(it) }
    }
}

@Composable
fun RoundItem(model: CollectionModel) {
    val size = 88

    Column(
        Modifier.width((size + 4).dp)
    ) {
        Image(
            painter = rememberCoilPainter(
                request = "${model.url}?auto=compress&cs=tinysrgb&dpr=3&h=$size&w=$size"
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(size.dp)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(percent = 50))
        )
        Text(
            model.name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .paddingFromBaseline(24.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeLightPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeDarkPreview() {
    MySootheTheme { HomeScreen() }
}
