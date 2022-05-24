package com.jonhbravo.heroes.data.di

import com.jonhbravo.heroes.data.repositories.HeroesRepository
import com.jonhbravo.heroes.data.repositories.HeroesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class HeroesRepositoriesModule {

    @Binds
    abstract fun bindsHeroesRepository(heroesRepository: HeroesRepositoryImpl): HeroesRepository
}