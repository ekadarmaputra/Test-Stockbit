package com.example.test_stockbit.ui.moviedetail.presenter

import com.example.test_stockbit.model.DetailMovie
import com.example.test_stockbit.network.service.MovieService
import com.example.test_stockbit.ui.moviedetail.contract.MovieDetailContract
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(): MovieDetailContract.Presenter {

    private var view: MovieDetailContract.View? = null
    @Inject
    lateinit var retrofit: Retrofit

    private val movieService by lazy { retrofit.create(MovieService::class.java) }

    override fun attachView(view: MovieDetailContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun loadMovieDetail(imdbId: String) {
        movieService.getMovieDetail(imdbId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(movieDetailObserver())
    }

    private fun movieDetailObserver(): SingleObserver<DetailMovie>{
        return object : SingleObserver<DetailMovie>{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onSuccess(movieDetail: DetailMovie) {
                view?.run {
                    showMovieDetail(movieDetail)
                    showMovieImage(movieDetail.image)
                }
            }

            override fun onError(e: Throwable) {
            }

        }
    }
}