package com.jonhbravo.heroes.core.network

import java.io.IOException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

typealias HeroesNetworkResponse<S> = NetworkResponse<S, GenericNetworkError>

sealed interface NetworkResponse<out T : Any, out U : Any> {
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>
    data class UnknownError(val error: Throwable) : NetworkResponse<Nothing, Nothing>
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Any> HeroesNetworkResponse<T>.onSuccess(action: (result: T) -> Unit): HeroesNetworkResponse<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    if (this is NetworkResponse.Success) action(this.body)
    return this
}

inline fun <T : Any> HeroesNetworkResponse<T>.onApiError(action: (result: GenericNetworkError, code: Int) -> Unit): HeroesNetworkResponse<T> {
    if (this is NetworkResponse.ApiError) action(this.body, this.code)
    return this
}

inline fun <T : Any> HeroesNetworkResponse<T>.onError(action: (exception: Throwable) -> Unit): HeroesNetworkResponse<T> {
    when(this) {
        is NetworkResponse.NetworkError -> this.error
        is NetworkResponse.UnknownError -> this.error
        else -> null
    }?.let(action)
    return this
}