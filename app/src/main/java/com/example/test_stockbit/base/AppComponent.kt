package com.example.test_stockbit.base

import android.app.Application
import com.example.test_stockbit.base.builder.ActivityBuilder
import com.example.test_stockbit.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [  AndroidSupportInjectionModule::class,
                        AppModule::class,
                        NetworkModule::class,
                        ActivityBuilder::class])
interface AppComponent: AndroidInjector<DaggerApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application):Builder
        fun build(): AppComponent
    }
    override fun inject(target: DaggerApplication)
}