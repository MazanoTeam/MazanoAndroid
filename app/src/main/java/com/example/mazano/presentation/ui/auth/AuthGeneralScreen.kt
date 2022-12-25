@file:OptIn(ExperimentalFoundationApi::class)

package com.example.mazano.presentation.ui.auth

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mazano.R
import com.example.mazano.common.exstensions.customTabIndicatorOffset
import com.example.mazano.presentation.theme.*
import com.example.mazano.presentation.ui.auth.create_account.CreateAccountScreen
import com.example.mazano.presentation.ui.auth.sign_in.SignInScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AuthGeneralScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val tabTitles = arrayListOf(
        stringResource(R.string.sign_in), stringResource(R.string.create_account)
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(Blue26)
    ) {
        AuthTabs(pagerState, scope, tabTitles)
        PagerSection(pagerState, tabTitles, navController)
    }
}

@Composable
fun AuthTabs(pagerState: PagerState, scope: CoroutineScope, tabs: ArrayList<String>) {
    val tabWidths = remember { mutableStateListOf(60.dp, 110.dp) }
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = Blue26,
        contentColor = Blue26,
        divider = { Box {} },
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .customTabIndicatorOffset(
                        tabPositions[pagerState.currentPage],
                        tabWidths[pagerState.currentPage]
                    )
                    .height(4.dp)
                    .background(color = YellowFF, shape = RoundedCornerShape(20.dp))
            )
        }) {
        tabs.forEachIndexed { index, text ->
            Tab(selected = index == pagerState.currentPage, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }, text = {
                Text(
                    text = text,
                    style = Bold14WithoutColor,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }, selectedContentColor = YellowFF, unselectedContentColor = GrayC5
            )
        }
    }
}

@Composable
fun PagerSection(pagerState: PagerState, pages: ArrayList<String>, navController: NavController) {
    HorizontalPager(
        pageCount = pages.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        when (it) {
            0 -> {
                SignInScreen(
                    navController = navController,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    pagerState
                )
            }
            1 -> {
                CreateAccountScreen(
                    navController = navController,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    pagerState = pagerState
                )
            }
        }
    }
}

@Composable
fun TestScreen(text: String) {
    Box(modifier = Modifier.fillMaxSize()) { Text(text = text) }
}

@Preview(showBackground = true)
@Composable
fun AuthGeneralPreview() {
    AuthGeneralScreen(rememberNavController())
}