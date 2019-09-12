package com.example.test_stockbit.ui.searchresult

import com.example.test_stockbit.base.builder.ActivityScoped
import com.example.test_stockbit.ui.searchresult.contract.SearchResultContract
import com.example.test_stockbit.ui.searchresult.presenter.SearchResultPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SearchResultModules {
    @ActivityScoped
    @Binds
    abstract fun searchResultPresenter(presenter: SearchResultPresenter): SearchResultContract.Presenter
}