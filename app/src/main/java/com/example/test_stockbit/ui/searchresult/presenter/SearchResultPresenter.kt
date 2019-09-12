package com.example.test_stockbit.ui.searchresult.presenter

import com.example.test_stockbit.model.SearchResponse
import com.example.test_stockbit.network.service.MovieService
import com.example.test_stockbit.ui.searchresult.contract.SearchResultContract
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class SearchResultPresenter @Inject constructor(): SearchResultContract.Presenter {

    private var view: SearchResultContract.View? = null

    @Inject
    lateinit var retrofit: Retrofit

    private val movieService by lazy { retrofit.create(MovieService::class.java) }

    override fun attachView(view: SearchResultContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun loadSearchResult(query: String) {
        movieService.getMovie(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(searchResultObserver())
    }

    private fun searchResultObserver(): SingleObserver<SearchResponse> {
        return object : SingleObserver<SearchResponse>{
            override fun onSubscribe(d: Disposable) {
                view?.showProgress()
            }

            override fun onSuccess(searchResponse: SearchResponse) {
                view?.run {
                    showProgressCompleted()
                    showSearchResult(searchResponse.results)
                }
            }

            override fun onError(e: Throwable) {
            }
        }
    }
}