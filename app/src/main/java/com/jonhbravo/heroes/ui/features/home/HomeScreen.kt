package com.jonhbravo.heroes.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jonhbravo.heroes.core.utils.heroes
import com.jonhbravo.heroes.ui.composables.HeroCard
import com.jonhbravo.heroes.ui.composables.HeroToolbar
import com.jonhbravo.heroes.ui.theme.HeroesTheme

@Composable
fun HomeStateContainer(
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.homeState.collectAsState()
    HomeScreen(homeState = state)
}

@Composable
fun HomeScreen(
    homeState: HomeState
) {
    Scaffold(
        topBar = {
            HeroToolbar()
        }
    ) {
        if (homeState is HomeState.Loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(80.dp),
                    color = MaterialTheme.colors.primary
                )
            }
        } else if (homeState is HomeState.Success) {
            LazyColumn {
                items(homeState.heroes) { hero ->
                    HeroCard(
                        name = hero.name,
                        imageUrl = hero.imageUrl,
                        description = hero.description
                    )
                }
                item {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenWithContentPreview() {
    HeroesTheme {
        HomeScreen(HomeState.Success(heroes))
    }
}

@Preview
@Composable
fun HomeScreenWithLoadingPreview() {
    HeroesTheme {
        HomeScreen(HomeState.Loading)
    }
}