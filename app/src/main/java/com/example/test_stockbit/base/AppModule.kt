package com.example.test_stockbit.base

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    private var app: Application? = null

//    constructor(application: Application){
//        app = application
//    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context? {
        return application
    }

//    @Provides
//    @Singleton
//    fun provideResource(): Resources? {
//        return context?.resources
//    }
}