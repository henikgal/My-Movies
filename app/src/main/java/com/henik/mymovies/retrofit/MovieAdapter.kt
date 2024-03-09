package com.henik.mymovies.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henik.mymovies.databinding.MovieItemBinding

class MovieAdapter(private val moviesList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(movie: Movie) {
            binding.movieItemTitle.setText(movie.title)
            binding.movieItemVoteAverage.setText(movie.voteAverage)
            binding.movieItemVoteCount.setText(movie.voteCount)
            binding.movieItemReleaseDate.setText(movie.releaseDate)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: MovieItemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(moviesList[position])
    }

}