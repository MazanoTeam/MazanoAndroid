package com.example.mazano.presentation.components.bottom_nav_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mazano.presentation.components.bottom_nav_bar.components.NavigationItem
import com.example.mazano.presentation.theme.*

@Composable
fun BottomNavigationBar(
    currentScreenId: String,
    onItemSelected: (NavigationItem) -> Unit,
) {
    val item = listOf(
        NavigationItem.Games,
        NavigationItem.Series,
        NavigationItem.Movies,
        NavigationItem.Search,
        NavigationItem.Profile
    )
    Row(
        modifier = Modifier
            .background(Blue060B.copy(0.7f), shape = RoundedCornerShape(20.dp))
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        item.forEach { item ->
            CustomBottomNavigationItem(item = item, isSelected = item.id == currentScreenId) {
                onItemSelected(item)
            }
        }
    }
}

@Composable
fun CustomBottomNavigationItem(
    item: NavigationItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val background =
        if (isSelected) White else Blue060B.copy(0f)
    val imageContentColor =
        if (isSelected) Blue26 else White
    val textContentStyle =
        if (isSelected) Bold14Blue26 else Bold14White
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(21.dp))
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = item.title,
                style = textContentStyle ,
            )
        }
    }
}

@Preview
@Composable
fun Prev1() {
    BottomNavigationBar(currentScreenId = NavigationItem.Games.id) {

    }
}

@Preview
@Composable
fun Prev2() {
    CustomBottomNavigationItem(item = NavigationItem.Games, isSelected = true) {

    }
}


