package com.jonhbravo.heroes.core.network

import com.google.gson.annotations.SerializedName

data class GenericNetworkError(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String
)
