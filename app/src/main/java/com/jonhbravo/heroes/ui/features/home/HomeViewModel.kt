package com.jonhbravo.heroes.ui.features.home

import androidx.lifecycle.ViewModel
import com.jonhbravo.heroes.domain.HeroesApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiService: HeroesApiService) : ViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState = _homeState.asStateFlow()
}