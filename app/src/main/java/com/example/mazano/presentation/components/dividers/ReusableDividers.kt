package com.example.mazano.presentation.components.dividers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.mazano.presentation.theme.Bold14GrayC5

@Composable
fun OrDivider(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Divider(modifier = Modifier.weight(5f))
        Text(
            text = "or",
            modifier = Modifier.weight(1f),
            style = Bold14GrayC5,
            textAlign = TextAlign.Center
        )
        Divider(modifier = Modifier.weight(5f))
    }
}