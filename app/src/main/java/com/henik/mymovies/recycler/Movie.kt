package com.henik.mymovies.recycler

import com.google.gson.annotations.SerializedName

data class Movie(
    val title : String,
    @SerializedName("poster_path")
    val posterPath : String,
    @SerializedName("vote_average")
    val voteAverage : Double,
    @SerializedName("vote_count")
    val voteCount: Double,
    @SerializedName("release_date")
    val releaseDate : String
)

