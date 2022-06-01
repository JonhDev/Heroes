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
import com.jonhbravo.heroes.ui.composables.Retry
import com.jonhbravo.heroes.ui.model.HeroUiModel
import com.jonhbravo.heroes.ui.theme.HeroesTheme

@Composable
fun HomeStateContainer(
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.homeState.collectAsState()
    HomeScreen(homeState = state) {
        viewModel.getHeroes()
    }
}

@Composable
fun HomeScreen(
    homeState: HomeUiState,
    onRetry: () -> Unit
) {
    Scaffold(
        topBar = {
            HeroToolbar()
        }
    ) {
        when (homeState) {
            HomeUiState.Loading -> LoadingScreen()
            HomeUiState.Error -> ErrorRetry(onRetry)
            is HomeUiState.Success -> HeroesList(heroes = homeState.heroes)
        }
    }
}

@Composable
fun LoadingScreen() {
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
}

@Composable
fun HeroesList(heroes: List<HeroUiModel>) {
    LazyColumn {
        items(heroes) { hero ->
            HeroCard(
                name = hero.name,
                imageUrl = hero.thumbnailUrl,
                description = hero.description
            )
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun ErrorRetry(onRetryClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Retry(onClick = onRetryClick)
    }
}

@Preview
@Composable
fun HomeScreenWithContentPreview() {
    HeroesTheme {
        HomeScreen(HomeUiState.Success(heroes)) { /** Nothing **/ }
    }
}

@Preview
@Composable
fun HomeScreenWithLoadingPreview() {
    HeroesTheme {
        HomeScreen(HomeUiState.Loading) { /** Nothing **/ }
    }
}

@Preview
@Composable
fun HomeScreenWithErrorPreview() {
    HeroesTheme {
        HomeScreen(HomeUiState.Error) { /** Nothing **/ }
    }
}