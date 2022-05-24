package com.jonhbravo.heroes.domain.di

import com.jonhbravo.heroes.core.utils.Mapper
import com.jonhbravo.heroes.data.model.HeroesApiModel
import com.jonhbravo.heroes.domain.mappers.HeroesMapper
import com.jonhbravo.heroes.ui.model.HeroUiModel
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MappersModule {

    @Binds
    @Reusable
    abstract fun bindsHeroesMapper(mapper: HeroesMapper): Mapper<HeroesApiModel, @JvmSuppressWildcards List<HeroUiModel>>
}