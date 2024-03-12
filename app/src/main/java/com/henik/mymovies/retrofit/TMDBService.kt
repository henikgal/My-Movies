package com.henik.mymovies.retrofit

import retrofit2.Call
import retrofit2.http.GET

private const val KEY : String = "&api_key=7b0239949c8841d324ba034bd178487c"
const val IMAGE_PREFIX = "https://image.tmdb.org/t/p/w500/"
interface TMDBService {

    @GET("3/trending/movie/week?language=en-US${KEY}")
    fun getTrendingMovies() : Call<TMDBResponse>

}