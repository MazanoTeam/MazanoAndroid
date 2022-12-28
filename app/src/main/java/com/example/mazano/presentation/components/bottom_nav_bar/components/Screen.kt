package com.example.mazano.presentation.components.bottom_nav_bar.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mazano.R

sealed class NavigationItem(
    val id: String,
    val title: String,
    val image: Int
    ) {

    object Games : NavigationItem("games","Games", R.drawable.ic_gamepad)
    object Series : NavigationItem("series","Series", R.drawable.ic_film)
    object Movies : NavigationItem("movies","Movies", R.drawable.ic_popcorn)
    object Search : NavigationItem("search","Search", R.drawable.ic_bottomnavbar_search)
    object Profile : NavigationItem("profile","Profile", R.drawable.ic_bottomnavbar_profile)

    object Items {
        val list = listOf(
            Games, Series, Movies, Search, Profile
        )
    }
}
