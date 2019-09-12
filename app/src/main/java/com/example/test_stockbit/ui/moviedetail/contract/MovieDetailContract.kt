package com.example.test_stockbit.ui.moviedetail.contract

import com.example.test_stockbit.base.BasePresenter
import com.example.test_stockbit.base.BaseView
import com.example.test_stockbit.model.DetailMovie

interface MovieDetailContract {
    interface Presenter: BasePresenter<View>{
        fun loadMovieDetail(imdbId: String)
    }

    interface View: BaseView{
        fun showMovieDetail(movieDetail: DetailMovie)
        fun showMovieImage(url: String)
    }
}