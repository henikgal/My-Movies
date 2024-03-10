package com.henik.mymovies.retrofit

import com.henik.mymovies.recycler.Movie

data class TMDBResponse (
    val results : List<Movie>
)