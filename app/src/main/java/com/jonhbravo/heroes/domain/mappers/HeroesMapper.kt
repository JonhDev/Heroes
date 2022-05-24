package com.jonhbravo.heroes.domain.mappers

import com.jonhbravo.heroes.core.utils.Mapper
import com.jonhbravo.heroes.data.model.HeroesApiModel
import com.jonhbravo.heroes.ui.model.HeroUiModel
import javax.inject.Inject

class HeroesMapper @Inject constructor() : Mapper<HeroesApiModel, @JvmSuppressWildcards List<HeroUiModel>> {

    override fun map(from: HeroesApiModel): List<HeroUiModel> {
        return from.data.results.map { heroApiModel ->
            HeroUiModel(
                id = heroApiModel.id,
                name = heroApiModel.name,
                description = heroApiModel.description,
                thumbnailUrl = with(heroApiModel.thumbnail) {
                    "$path.$extension"
                }
            )
        }
    }
}