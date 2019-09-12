package com.example.test_stockbit.network

import com.example.test_stockbit.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", BuildConfig.OMDB_API_KEY)
            .build()

        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}