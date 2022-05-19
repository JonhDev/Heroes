package com.jonhbravo.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jonhbravo.heroes.core.utils.heroes
import com.jonhbravo.heroes.ui.features.home.HomeScreen
import com.jonhbravo.heroes.ui.features.home.HomeState
import com.jonhbravo.heroes.ui.theme.HeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeState: HomeState by remember { mutableStateOf(HomeState.Success(heroes)) }
            HeroesTheme {
                HomeScreen(homeState)
            }
        }
    }
}