package com.example.test_stockbit.ui.searchresult.contract

import com.example.test_stockbit.base.BasePresenter
import com.example.test_stockbit.base.BaseView
import com.example.test_stockbit.model.Movie

interface SearchResultContract {

    interface Presenter: BasePresenter<View>{
        fun loadSearchResult(query: String)
    }

    interface View: BaseView{
        fun showSearchResult(movieResults: ArrayList<Movie>)
        fun showProgress()
        fun showProgressCompleted()
    }
}