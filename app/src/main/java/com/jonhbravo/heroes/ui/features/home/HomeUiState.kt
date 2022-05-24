package com.jonhbravo.heroes.ui.features.home

import com.jonhbravo.heroes.ui.model.HeroUiModel

sealed interface HomeUiState {
    object Loading : HomeUiState
    object Error : HomeUiState
    data class Success(val heroes: List<HeroUiModel>) : HomeUiState
}