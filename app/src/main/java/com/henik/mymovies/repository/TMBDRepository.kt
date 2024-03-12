package com.henik.mymovies.repository

import com.henik.mymovies.recycler.Movie


interface TMDBRepository {

    fun getTrendingMovies (callback:(List<Movie>) -> Unit)


}