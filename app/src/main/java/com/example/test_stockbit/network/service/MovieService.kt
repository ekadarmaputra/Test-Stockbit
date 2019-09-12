package com.example.test_stockbit.network.service

import com.example.test_stockbit.model.DetailMovie
import com.example.test_stockbit.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("?type=movie")
    fun getMovie(@Query("s") title:String): Single<SearchResponse>

    @GET("?plot=full")
    fun getMovieDetail(@Query("i") imdbId: String): Single<DetailMovie>
}