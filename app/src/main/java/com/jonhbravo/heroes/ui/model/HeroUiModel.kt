package com.jonhbravo.heroes.ui.model

data class HeroUiModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String = ""
)
