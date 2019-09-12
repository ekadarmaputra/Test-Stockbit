package com.example.test_stockbit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
class Rating {
    @SerializedName("Source")
    @Expose
    lateinit var source: String

    @SerializedName("Value")
    @Expose
    lateinit var value: String
}