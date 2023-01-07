package com.example.mazano.presentation.ui.media.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mazano.R
import com.example.mazano.presentation.theme.GrayBA
import com.example.mazano.presentation.theme.White

@Composable
fun CommentItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_sign_out),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Spacer(modifier = Modifier.padding(start = 5.dp))
        Column() {
            Text(
                text = "Elon Musk",
                fontSize = 14.sp,
                color = GrayBA
            )
            Spacer(modifier = Modifier.padding(bottom = 2.dp))
            Text(
                text = "Elon Reeve Musk[* 1] (eng. Elon Reeve Musk, MFA: [ˈiːlɒn 'mʌsk]; born June 28, 1971[1][2][3][…], Pretoria) is an American entrepreneur, engineer[6] and billionaire",
                fontSize = 14.sp,
                color = White,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            Spacer(modifier = Modifier.padding(bottom = 2.dp))
            Text(
                text = "01-24",
                fontSize = 14.sp,
                color = GrayBA
            )
        }
        Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            IconButton(onClick = {}, modifier = Modifier
                .width(20.dp)
                .height(20.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_comment),
                    contentDescription = null,
                    tint = White,
                )
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "513",
                    fontSize = 10.sp,
                    color = White,
                )
            }
        }
    }
}

@Composable
@Preview
fun Prev() {
    CommentItem()
}