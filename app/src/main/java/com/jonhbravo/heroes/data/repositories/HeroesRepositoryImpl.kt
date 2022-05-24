package com.jonhbravo.heroes.data.repositories

import com.jonhbravo.heroes.core.di.IODispatcher
import com.jonhbravo.heroes.data.services.HeroesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val heroesApiService: HeroesApiService,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : HeroesRepository {

    override suspend fun getHeroes() = withContext(ioDispatcher) {
        heroesApiService.getCharacters()
    }
}