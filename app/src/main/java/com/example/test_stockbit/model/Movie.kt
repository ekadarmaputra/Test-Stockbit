package com.example.test_stockbit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
class Movie {
    @SerializedName("Title")
    @Expose
    lateinit var title: String

    @SerializedName("Year")
    @Expose
    lateinit var year: String

    @SerializedName("imdbID")
    @Expose
    lateinit var imdbID: String

    @SerializedName("Type")
    @Expose
    lateinit var type: String

    @SerializedName("Poster")
    @Expose
    lateinit var image: String
}