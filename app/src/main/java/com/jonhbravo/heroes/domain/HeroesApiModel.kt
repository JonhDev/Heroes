package com.jonhbravo.heroes.domain

import com.google.gson.annotations.SerializedName

data class HeroesApiModel(
    @SerializedName("data") val data: HeroesApiData
)

data class HeroesApiData(
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<HeroApiModel>
)

data class HeroApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailApiModel
)

data class ThumbnailApiModel(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)