package com.jonhbravo.heroes.ui.features.home

import com.jonhbravo.heroes.core.model.Hero

sealed interface HomeState {
    object Loading : HomeState
    data class Success(val heroes: List<Hero>) : HomeState
}