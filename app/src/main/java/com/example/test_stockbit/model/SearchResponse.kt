package com.example.test_stockbit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
class SearchResponse {
    @SerializedName("Search")
    @Expose
    lateinit var results: ArrayList<Movie>

    @SerializedName("totalResults")
    @Expose
    lateinit var totalResults: String

    @SerializedName("Response")
    @Expose
    lateinit var response: String
}