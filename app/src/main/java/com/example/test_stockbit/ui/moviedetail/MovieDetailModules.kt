package com.example.test_stockbit.ui.moviedetail

import com.example.test_stockbit.base.builder.ActivityScoped
import com.example.test_stockbit.ui.moviedetail.contract.MovieDetailContract
import com.example.test_stockbit.ui.moviedetail.presenter.MovieDetailPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MovieDetailModules {

    @ActivityScoped
    @Binds
    abstract fun movieDetailPresenter(presenter: MovieDetailPresenter): MovieDetailContract.Presenter
}