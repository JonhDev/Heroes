package com.jonhbravo.heroes.domain.usecases

import com.jonhbravo.heroes.core.di.IODispatcher
import com.jonhbravo.heroes.core.network.NetworkResponse
import com.jonhbravo.heroes.core.utils.HeroesException
import com.jonhbravo.heroes.core.utils.Mapper
import com.jonhbravo.heroes.data.model.HeroesApiModel
import com.jonhbravo.heroes.data.repositories.HeroesRepository
import com.jonhbravo.heroes.ui.model.HeroUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    private val heroesRepository: HeroesRepository,
    private val heroesMapper: Mapper<HeroesApiModel, @JvmSuppressWildcards List<HeroUiModel>>,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): List<HeroUiModel> = withContext(ioDispatcher) {
        val response = heroesRepository.getHeroes()
        if (response is NetworkResponse.Success<HeroesApiModel>) {
            heroesMapper.map(response.body)
        } else throw HeroesException("Error getting heroes")
    }
}