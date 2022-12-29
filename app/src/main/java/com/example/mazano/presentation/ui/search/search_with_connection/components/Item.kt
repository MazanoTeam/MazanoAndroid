package com.example.mazano.presentation.ui.search.search_with_connection.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mazano.R
import com.example.mazano.presentation.theme.Bold14White
import com.example.mazano.presentation.theme.White

@Composable
fun Item(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email), contentDescription = null, modifier = Modifier
                    .align(Alignment.TopStart)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_like_search_screen),
                    contentDescription = null
                )
                Text(
                    text = "666",
                    fontSize = 8.sp,
                    fontStyle = FontStyle.Italic,
                    color = White
                )
            }
        }
        Spacer(modifier = Modifier.padding(11.dp))
        Column (
            Modifier.fillMaxWidth(0.55f)
                ) {
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "FilmName",
                style = Bold14White
            )
            Spacer(modifier = Modifier.padding(9.dp))
            Text(
                text = "FilmDate",
                style = Bold14White
            )
            Spacer(modifier = Modifier.padding(9.dp))
            Text(
                text = "FilmGenre",
                style = Bold14White
            )
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}

@Composable
@Preview
fun Prev1() {
    Item()
}