package com.example.test_stockbit.base.builder

import com.example.test_stockbit.ui.launcher.LauncherActivity
import com.example.test_stockbit.ui.launcher.LauncherModules
import com.example.test_stockbit.ui.SearchModules
import com.example.test_stockbit.ui.SearchActivity
import com.example.test_stockbit.ui.moviedetail.MovieDetailActivity
import com.example.test_stockbit.ui.moviedetail.MovieDetailModules
import com.example.test_stockbit.ui.searchresult.MainActivity
import com.example.test_stockbit.ui.searchresult.SearchResultModules
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchResultModules::class])
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchModules::class])
    abstract fun searchActivity(): SearchActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LauncherModules::class])
    abstract fun launcherActivity(): LauncherActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MovieDetailModules::class])
    abstract fun movieDetailActivity(): MovieDetailActivity

}