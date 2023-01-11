package com.example.mazano.presentation.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.mazano.R
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.mazano.presentation.theme.*
import com.example.mazano.presentation.ui.welcome.data.listData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun GreetingScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val (selectedPage, setSelectedPage) = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (selectedPage == 0) YellowFF else if(selectedPage == 1) Blue00 else RedFF)
    ) {
        HorizontalPager(
            count = listData.size,
            state = pagerState,
            modifier = Modifier.weight(0.6f),
            verticalAlignment = Alignment.Top
        ) { page ->
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(listData[page].resId))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(12.dp)
            ) {
                LottieAnimation(
                    composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.weight(0.3f)
                )
                Text(
                    text = "Welcome to Mazano",
                    fontSize = 20.sp,
                    color = if (currentPage == 0) Black else Color.Transparent,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp),
                )
                Text(
                    text = listData[page].desc,
                    fontSize = 20.sp,
                    color = Black,
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(65.dp)
        ) {
            for (i in listData.indices) {
                Box(
                    modifier = Modifier
                        .padding(end = 35.dp)
                        .width(15.dp)
                        .height(1.dp)
                        .background(
                            if (i == selectedPage) Black else White
                        )
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextButton(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(listData.size - 1)
                    }
                },
                modifier = Modifier.height(56.dp)
            ) {
                Text(
                    text = "Skip",
                    fontSize = 18.sp,
                    color = Black,
                    textAlign = TextAlign.Center
                )
            }
            IconButton(onClick = {
                scope.launch {
                    val nextPage = selectedPage + 1
                    pagerState.animateScrollToPage(nextPage)
                }
            },
                modifier = Modifier
                    .height(56.dp)
                    .width(64.dp)
            ) {
                Row () {
                    Text(
                        text = "Next",
                        fontSize = 18.sp,
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(end = 8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_page_welcome_screen),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(top = 1.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun Prev() {
    GreetingScreen()
}