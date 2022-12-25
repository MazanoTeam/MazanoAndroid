@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mazano.presentation.components.input_fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mazano.R
import com.example.mazano.presentation.theme.*

@Composable
fun NameInputField(modifier: Modifier, hintText: String, text: MutableState<String>) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.name),
            style = Bold14White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = { value -> text.value = value },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(hintText, style = Bold14Gray74)
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_textfield_profile),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            },
            singleLine = true,
            textStyle = Bold14Black
        )
    }
}

@Composable
fun PasswordInputField(
    modifier: Modifier,
    hintText: String,
    text: MutableState<String>,
    forgotPasswordIsVisible: Boolean
) {
    val passwordVisible = remember { mutableStateOf(false) }
    Column(modifier) {
        Text(
            text = stringResource(R.string.password),
            style = Bold14White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = { value -> text.value = value },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(hintText, style = Bold14Gray74)
            },
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.ic_key), contentDescription = null)
            },
            singleLine = true,
            trailingIcon = {
                val image = if (passwordVisible.value) painterResource(id = R.drawable.ic_eye)
                else painterResource(id = R.drawable.ic_eye_crossed)

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(image, null)
                }
            },
            textStyle = Bold14Black,
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )
        if (forgotPasswordIsVisible) {
            Text(
                text = stringResource(R.string.forgot_password),
                style = Bold14White,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun EmailInputField(modifier: Modifier, hintText: String, text: MutableState<String>) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.email),
            style = Bold14White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = { value -> text.value = value },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {
                Text(hintText, style = Bold14Gray74)
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            },
            singleLine = true,
            textStyle = Bold14Black
        )
    }
}