package com.jonhbravo.heroes.ui.features.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jonhbravo.heroes.core.utils.heroes
import com.jonhbravo.heroes.ui.composables.HeroCard
import com.jonhbravo.heroes.ui.composables.HeroToolbar
import com.jonhbravo.heroes.ui.theme.HeroesTheme

@Composable
fun HomeScreen(
    homeState: HomeState
) {
    Scaffold(
        topBar = {
            HeroToolbar()
        }
    ) {
        if (homeState is HomeState.Success) {
            LazyColumn {
                items(homeState.heroes) { hero ->
                    HeroCard(
                        name = hero.name,
                        imageUrl = hero.imageUrl,
                        description = hero.description
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HeroesTheme {
        HomeScreen(HomeState.Success(heroes))
    }
}