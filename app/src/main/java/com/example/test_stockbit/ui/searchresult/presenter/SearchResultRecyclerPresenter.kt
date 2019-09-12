package com.example.test_stockbit.ui.searchresult.presenter

import com.example.test_stockbit.model.Movie
import com.example.test_stockbit.ui.searchresult.adapter.SearchResultAdapter

class SearchResultRecyclerPresenter(private var movieResults: ArrayList<Movie>) {

    val itemCount: Int get() = movieResults.size

    fun onBindViewHolderAtPosition(holder: SearchResultAdapter.ViewHolder, position: Int){
        val movieResult = movieResults[position]

        holder.apply {
            showMovieImage(movieResult.image)
            showMovieTitle(movieResult.title)
            showMovieYear(movieResult.year)

            setClickedMovieItem(movieResult, position)
        }
    }

    fun updateResult(movieResults: ArrayList<Movie>){
        this.movieResults = movieResults
    }
}