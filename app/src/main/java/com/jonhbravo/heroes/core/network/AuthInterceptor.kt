package com.jonhbravo.heroes.core.network

import com.jonhbravo.heroes.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url

        val url = originalUrl.newBuilder()
            .addQueryParameter(TS, BuildConfig.TS)
            .addQueryParameter(API_KEY, BuildConfig.API_KEY)
            .addQueryParameter(HASH, BuildConfig.HASH)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(newRequest)
    }

    private companion object {
        const val TS = "ts"
        const val API_KEY = "apikey"
        const val HASH = "hash"
    }
}