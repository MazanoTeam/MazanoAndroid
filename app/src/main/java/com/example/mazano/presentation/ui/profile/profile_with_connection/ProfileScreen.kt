package com.example.mazano.presentation.ui.profile.profile_with_connection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mazano.R
import com.example.mazano.presentation.theme.*
import com.example.mazano.presentation.ui.profile.profile_with_connection.components.ProfileItem

@Composable
fun ProfileScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Blue070D2C)
    ) {
        Row(
            Modifier.padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_sign_out),
                contentDescription = null,
                tint = White
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .border(1.dp, color = GrayBA, shape = RoundedCornerShape(18.dp))
                        .background(White, RoundedCornerShape(12.dp))
                        .height(22.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dark_theme),
                            contentDescription = null,
                            tint = Blue070D2D
                        )
                        Spacer(modifier = Modifier.padding(start = 4.dp))
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "night",
                                color = Blue070D2D,
                                fontSize = 7.sp
                            )
                        }
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Blue0A
            )
        ) {
            Column() {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Name Field",
                        fontSize = 30.sp,
                        color = White,
                        modifier = Modifier
                            .padding(20.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_gamepad),
                        contentDescription = null,
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .padding(8.dp)
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Email Field",
                        fontSize = 16.sp,
                        color = White,
                        modifier = Modifier
                            .padding(bottom = 20.dp, start = 20.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit_account_info),
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier
                            .padding(bottom = 15.dp, end = 15.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box(modifier = Modifier.align(CenterHorizontally)) {
            Text(
                text = "Saved",
                fontSize = 32.sp,
                color = White
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        LazyVerticalGrid(

            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp),
            content = {
                items(12) {
                    ProfileItem()
                }
            }
        )
    }
}

@Composable
@Preview
fun Prev() {
    ProfileScreen()
}