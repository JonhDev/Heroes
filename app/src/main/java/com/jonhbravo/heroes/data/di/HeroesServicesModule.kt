package com.jonhbravo.heroes.data.di

import com.jonhbravo.heroes.data.services.HeroesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object HeroesServicesModule {

    @Provides
    fun providesHeroesApiService(retrofit: Retrofit): HeroesApiService {
        return retrofit.create(HeroesApiService::class.java)
    }
}