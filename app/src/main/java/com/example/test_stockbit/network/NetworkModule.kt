package com.example.test_stockbit.network

import com.example.test_stockbit.BuildConfig
import com.example.test_stockbit.network.service.MovieService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    private val CONNECT_TIMEOUT_IN_MS = 30000

    @Provides
    @Singleton
    fun requestInterceptor(interceptor: RequestInterceptor): Interceptor {
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(CONNECT_TIMEOUT_IN_MS.toLong(), TimeUnit.MILLISECONDS)
            .addInterceptor(requestInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.OMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}