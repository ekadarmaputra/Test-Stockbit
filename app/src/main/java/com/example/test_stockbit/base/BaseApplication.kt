package com.example.test_stockbit.base

import com.example.test_stockbit.network.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()

        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()

    }


}