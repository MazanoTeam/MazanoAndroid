package com.example.mazano.presentation.ui.media

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mazano.R
import com.example.mazano.presentation.theme.*
import com.example.mazano.presentation.ui.media.components.CommentItem

@Composable
fun MediaDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_gamepad),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 12.dp, start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_media_screen),
                    contentDescription = null,
                    tint = YellowFF
                )
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_unfavourite_media_screen
                    ),
                    contentDescription = null,
                    tint = YellowFF
                )
            }
            Spacer(modifier = Modifier.padding(top = 80.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Fast and furious 9",
                    fontSize = 20.sp,
                    color = White
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(YellowFF, CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play_media_screen),
                        contentDescription = null
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Blue070D2D, RoundedCornerShape(24.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 24.dp, end = 24.dp)
            ) {
                Column() {
                    Text(
                        text = "Year",
                        fontSize = 20.sp,
                        color = White
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(text = "2021",
                        fontSize = 20.sp,
                        color = White
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Divider(
                    thickness = 1.dp, modifier = Modifier
                        .width(1.dp)
                        .padding(top = 5.dp)
                        .height(57.dp), color = DividerDefaults.color
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Time",
                        fontSize = 20.sp,
                        color = White,
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text(
                        text = "2 h 23 min",
                        fontSize = 20.sp,
                        color = White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_media_screen),
                            contentDescription = null,
                            tint = YellowFF
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 2.dp))
                    Box() {
                        Text(
                            text = "231",
                            fontSize = 12.sp,
                            color = White,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(3.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                text = "Description:",
                fontSize = 24.sp,
                color = White,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "Dominic Toretto leads a quiet life with Letty and his son Brian, however, they know that new danger is always somewhere nearby. This time, Dominic will have to face the ghosts of the past if he wants to save those closest to him. The team comes together again to stop a daring plan to take over the world from the most dangerous criminal and crazy driver they've ever encountered.",
                fontSize = 20.sp,
                color = GrayBA,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 6.dp, bottom = 6.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Comments",
                    fontSize = 24.sp,
                    color = White
                )
            }
            LazyColumn(content = {
                items(2) {
                    CommentItem()
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            },
                modifier = Modifier.padding(start = 24.dp, end = 24.dp))
        }
    }
}

@Composable
@Preview
fun Prev() {
    MediaDetailScreen()
}