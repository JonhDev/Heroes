package com.jonhbravo.heroes.data.services

import com.jonhbravo.heroes.core.network.HeroesNetworkResponse
import com.jonhbravo.heroes.data.model.HeroesApiModel
import retrofit2.http.GET

interface HeroesApiService {

    @GET("v1/public/characters")
    suspend fun getCharacters(): HeroesNetworkResponse<HeroesApiModel>
}