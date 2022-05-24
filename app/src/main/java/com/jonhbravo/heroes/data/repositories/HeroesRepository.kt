package com.jonhbravo.heroes.data.repositories

import com.jonhbravo.heroes.core.network.HeroesNetworkResponse
import com.jonhbravo.heroes.data.model.HeroesApiModel

interface HeroesRepository {
    suspend fun getHeroes(): HeroesNetworkResponse<HeroesApiModel>
}