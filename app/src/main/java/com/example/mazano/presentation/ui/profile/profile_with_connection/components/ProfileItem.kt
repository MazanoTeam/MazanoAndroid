package com.example.mazano.presentation.ui.profile.profile_with_connection.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mazano.R
import com.example.mazano.presentation.theme.White

@Composable
fun ProfileItem() {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier
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
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Object Name",
                color = White
            )
        }
    }
}

@Composable
@Preview
fun Prev() {
    ProfileItem()
}