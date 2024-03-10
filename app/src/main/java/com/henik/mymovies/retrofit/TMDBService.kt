package com.henik.mymovies.retrofit

import retrofit2.Call
import retrofit2.http.GET

private const val key : String = "&api_key=7b0239949c8841d324ba034bd178487c"
interface TMDBService {

    @GET("3/trending/movie/week?language=en-US${key}")
    fun getTrendingMovies() : Call<TMDBResponse>

}