package com.example.test_stockbit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
class DetailMovie {
    @SerializedName("Title")
    @Expose
    lateinit var title: String

    @SerializedName("Year")
    @Expose
    lateinit var year: String

    @SerializedName("Rated")
    @Expose
    lateinit var rated: String

    @SerializedName("Runtime")
    @Expose
    lateinit var runtime: String

    @SerializedName("Released")
    @Expose
    lateinit var released: String

    @SerializedName("Genre")
    @Expose
    lateinit var genre: String

    @SerializedName("Director")
    @Expose
    lateinit var director: String

    @SerializedName("Writer")
    @Expose
    lateinit var writer: String

    @SerializedName("Actors")
    @Expose
    lateinit var actor: String

    @SerializedName("Plot")
    @Expose
    lateinit var plot: String

    @SerializedName("Language")
    @Expose
    lateinit var languange: String

    @SerializedName("Country")
    @Expose
    lateinit var country: String

    @SerializedName("Awards")
    @Expose
    lateinit var awards: String

    @SerializedName("Poster")
    @Expose
    lateinit var image: String

    @SerializedName("Ratings")
    @Expose
    lateinit var ratings: List<Rating>

    @SerializedName("Metascore")
    @Expose
    lateinit var metaScore: String

    @SerializedName("imdbRating")
    @Expose
    lateinit var imdbRating: String

    @SerializedName("imdbVotes")
    @Expose
    lateinit var imdbVotes: String

    @SerializedName("imdbID")
    @Expose
    lateinit var imdbID: String

    @SerializedName("Type")
    @Expose
    lateinit var type: String

    @SerializedName("DVD")
    @Expose
    lateinit var dvd: String

    @SerializedName("BoxOffice")
    @Expose
    lateinit var boxOffice: String

    @SerializedName("Production")
    @Expose
    lateinit var production: String

    @SerializedName("Website")
    @Expose
    lateinit var website: String

    @SerializedName("Response")
    @Expose
    lateinit var response: String
}