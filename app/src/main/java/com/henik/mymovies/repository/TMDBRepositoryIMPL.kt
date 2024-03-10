package com.henik.mymovies.repository

import com.henik.mymovies.recycler.Movie
import com.henik.mymovies.retrofit.RetrofitInstance
import com.henik.mymovies.retrofit.TMDBResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TMDBRepositoryIMPL : TMDBRepository {
    override fun getTrendingMovies(callback: (List<Movie>) -> Unit) {
        RetrofitInstance.retrofit.getTrendingMovies().enqueue(object : Callback<TMDBResponse?> {
            override fun onResponse(call: Call<TMDBResponse?>, response: Response<TMDBResponse?>) {
                if (response.isSuccessful) {
                    response.body()?.let { movies ->
                        callback.invoke(movies.results)
                    }
                }
            }

            override fun onFailure(call: Call<TMDBResponse?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


}