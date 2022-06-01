package com.jonhbravo.heroes.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonhbravo.heroes.data.repositories.HeroesRepository
import com.jonhbravo.heroes.domain.usecases.GetHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getHeroesUseCase: GetHeroesUseCase) :
    ViewModel() {

    private val _homeState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val homeState = _homeState.asStateFlow()

    init {
        getHeroes()
    }

    fun getHeroes() {
        viewModelScope.launch {
            _homeState.value = HomeUiState.Loading
            _homeState.value = try {
                HomeUiState.Success(getHeroesUseCase())
            } catch (ex: Exception) {
                HomeUiState.Error
            }
        }
    }
}