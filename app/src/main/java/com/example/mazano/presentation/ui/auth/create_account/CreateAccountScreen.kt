@file:OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)

package com.example.mazano.presentation.ui.auth.create_account

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mazano.R
import com.example.mazano.presentation.components.dividers.OrDivider
import com.example.mazano.presentation.components.input_fields.EmailInputField
import com.example.mazano.presentation.components.input_fields.NameInputField
import com.example.mazano.presentation.components.input_fields.PasswordInputField
import com.example.mazano.presentation.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CreateAccountScreen(navController: NavController, modifier: Modifier, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    Column(
        Modifier
            .fillMaxSize()
            .background(Blue26)
    ) {
        TopSection(
            navController = navController,
            modifier = modifier
        )
        BottomSection(
            modifier = modifier,
            pagerState,
            scope
        )
    }
}


@Composable
fun TopSection(navController: NavController, modifier: Modifier) {
    val nameText = remember { mutableStateOf("") }
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }

    NameInputField(modifier, stringResource(R.string.enter_name), nameText)
    EmailInputField(modifier.padding(top = 15.dp), stringResource(R.string.enter_email), emailText)
    PasswordInputField(
        modifier.padding(top = 15.dp), stringResource(R.string.enter_password), passwordText, false
    )
    OutlinedButton(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = YellowFF),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = stringResource(id = R.string.sign_in), style = Bold14Black)
    }
    OrDivider(modifier.padding(top = 45.dp))
}

@Composable
fun BottomSection(modifier: Modifier, pagerState: PagerState, scope: CoroutineScope) {
    Column {
        OutlinedButton(
            onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 55.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    )
                )
                Text(
                    text = stringResource(id = R.string.continue_with_google),
                    style = Bold14Black2F,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 70.dp)
        ) {
            Text(text = stringResource(R.string.already_have_account), style = Bold14GrayC5)
            ClickableText(text = buildAnnotatedString {
                append(stringResource(R.string.sign_in))
            }, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(0)
                }
            }, style = Bold14Yellow, modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CreateAccountPreview() {
    CreateAccountScreen(
        rememberNavController(), Modifier.padding(horizontal = 10.dp), rememberPagerState()
    )
}
