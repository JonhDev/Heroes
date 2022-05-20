package com.jonhbravo.heroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jonhbravo.heroes.ui.features.home.HomeStateContainer
import com.jonhbravo.heroes.ui.theme.HeroesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroesTheme {
                HomeStateContainer()
            }
        }
    }
}