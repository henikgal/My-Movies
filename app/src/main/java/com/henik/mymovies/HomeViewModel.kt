package com.henik.mymovies;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.henik.mymovies.recycler.Movie
import com.henik.mymovies.repository.TMDBRepository


public class HomeViewModel(private val repository: TMDBRepository) : ViewModel() {

    private val trendingMoviesMutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val trendingMoviesLiveData: LiveData<List<Movie>> = trendingMoviesMutableLiveData

    fun getTrendingMovies() {
        repository.getTrendingMovies { movies ->
            trendingMoviesMutableLiveData.postValue(movies)
        }

    }
}

class HomeViewModelFactory(private val repository: TMDBRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
