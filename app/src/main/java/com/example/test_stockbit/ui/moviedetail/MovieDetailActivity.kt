package com.example.test_stockbit.ui.moviedetail

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.test_stockbit.R
import com.example.test_stockbit.base.BaseActivity
import com.example.test_stockbit.model.DetailMovie
import com.example.test_stockbit.ui.moviedetail.contract.MovieDetailContract
import com.example.test_stockbit.ui.moviedetail.presenter.MovieDetailPresenter
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity: BaseActivity(), MovieDetailContract.View {

    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        presenter.attachView(this)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent){
        val movieId = intent.getStringExtra("movieId")
        presenter.loadMovieDetail(movieId)
    }

    override fun showMovieDetail(movieDetail: DetailMovie) {
        txtTitle.text = movieDetail.title
        txtRelease.text = movieDetail.released
        txtRuntime.text = movieDetail.runtime
        txtDirector.text = movieDetail.director
        txtCategory.text = movieDetail.genre
        txtWriter.text = movieDetail.writer
        txtActors.text = movieDetail.actor
        txtPlot.text = movieDetail.plot

    }

    override fun showMovieImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(main_backdrop)
    }

    override fun showErrorMessage(message: String) {
    }
}