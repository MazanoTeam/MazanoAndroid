package com.example.mazano.presentation.ui.search.search_with_connection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mazano.R
import com.example.mazano.presentation.theme.Blue060C
import com.example.mazano.presentation.theme.White
import com.example.mazano.presentation.ui.search.search_with_connection.components.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenWithConnection(
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue060C)
    ) {
        TextField(
            value = text,
            onValueChange = {},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search_search_screen),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
            singleLine = true,
            shape = RoundedCornerShape(18.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(
            modifier = Modifier
                .padding(top = 42.dp)
        )
        LazyColumn (
            modifier = Modifier
                .padding(start = 13.dp)
        ) {
            items(5) {
                Item()
                Spacer(modifier = Modifier.padding(top = 31.dp))
            }
        }

    }
}


@Composable
@Preview
fun Prev() {
    SearchScreenWithConnection(text = "Mazano")
}