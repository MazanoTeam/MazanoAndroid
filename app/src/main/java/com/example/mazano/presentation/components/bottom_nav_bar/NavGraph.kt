package com.example.mazano.presentation.components.bottom_nav_bar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mazano.presentation.components.bottom_nav_bar.components.NavigationItem
import com.example.mazano.presentation.ui.games.GamesScreen
import com.example.mazano.presentation.ui.movies.MoviesScreen
import com.example.mazano.presentation.ui.profile.ProfileScreen
import com.example.mazano.presentation.ui.search.SearchScreen
import com.example.mazano.presentation.ui.series.SeriesScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Games.id) {
        composable(NavigationItem.Games.id) {
            GamesScreen()
        }
        composable(NavigationItem.Series.id) {
            SeriesScreen()
        }
        composable(NavigationItem.Movies.id) {
            MoviesScreen()
        }
        composable(NavigationItem.Search.id) {
            SearchScreen()
        }
        composable(NavigationItem.Profile.id) {
            ProfileScreen()
        }
    }
}