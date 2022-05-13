package com.jonhbravo.heroes.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jonhbravo.heroes.ui.composables.HeroCard
import com.jonhbravo.heroes.ui.composables.HeroToolbar
import com.jonhbravo.heroes.ui.theme.HeroesTheme
import com.jonhbravo.heroes.utils.heroes

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HeroToolbar()
        }
    ) {
        LazyColumn {
            items(heroes) { hero ->
                HeroCard(
                    name = hero.name,
                    author = hero.author,
                    description = hero.description
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HeroesTheme {
        HomeScreen()
    }
}