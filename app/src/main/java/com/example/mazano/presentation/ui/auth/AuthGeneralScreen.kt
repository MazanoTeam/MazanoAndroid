@file:OptIn(ExperimentalFoundationApi::class)

package com.example.mazano.presentation.ui.auth

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mazano.R
import com.example.mazano.presentation.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(navController: NavController, modifier: Modifier) {
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
        PagerSection(pagerState, tabTitles)
    }
}

@Composable
fun AuthTabs(pagerState: PagerState, scope: CoroutineScope, tabs: ArrayList<String>) {
    TabRow(selectedTabIndex = pagerState.currentPage,
        containerColor = Blue26,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    .height(4.dp)
                    .background(color = YellowFF)
            )
        }) {
        tabs.forEachIndexed { index, text ->
            Tab(selected = index == pagerState.currentPage,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = text, style = Bold14WithoutColor) },
                selectedContentColor = YellowFF,
                unselectedContentColor = GrayC5
            )
        }
    }
}

@Composable
fun PagerSection(pagerState: PagerState, pages: ArrayList<String>) {
    HorizontalPager(
        pageCount = pages.size, state = pagerState, modifier = Modifier.fillMaxSize()
    ) {
        when (it) {
            0 -> {
                TestScreen(text = "0")
            }
            1 -> {
                TestScreen(text = "2")
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
fun DefaultPreview() {
    AuthScreen(rememberNavController(), Modifier)
}