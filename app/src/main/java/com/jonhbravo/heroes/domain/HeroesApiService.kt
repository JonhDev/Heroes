package com.jonhbravo.heroes.domain

import com.jonhbravo.heroes.core.network.HeroesNetworkResponse
import retrofit2.http.GET

interface HeroesApiService {

    @GET("v1/public/characters")
    suspend fun getCharacters(): HeroesNetworkResponse<HeroesApiModel>
}