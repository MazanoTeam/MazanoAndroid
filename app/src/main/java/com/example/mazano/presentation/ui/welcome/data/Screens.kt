package com.example.mazano.presentation.ui.welcome.data

import androidx.annotation.RawRes
import com.example.mazano.R
import com.example.mazano.presentation.theme.Blue00
import com.example.mazano.presentation.theme.RedFF
import com.example.mazano.presentation.theme.YellowFF

class Screens(@RawRes val resId: Int, val desc: String)

val listData = listOf(
    Screens(
        R.raw.first_greeting_screen_animation,
        "Here you can find the movie \n" +
                "you need and watch it with\n" +
                "great pleasure",
    ),
    Screens(
        R.raw.second_greeting_screen_animation,
        "And also here you can find \n" +
                "the game you need",
    ),
    Screens(
        R.raw.third_greeting_screen_animation,
        "And finally here you can find\n" +
                "the book you want to read",
    )
)