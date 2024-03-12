package com.henik.mymovies;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.henik.mymovies.databinding.FragmentHomeBinding;
import com.henik.mymovies.recycler.MovieAdapter;
import com.henik.mymovies.recycler.MovieClickedCallback;
import com.henik.mymovies.repository.TMDBRepositoryIMPL;

public class HomeFragment extends Fragment implements MovieClickedCallback {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(requireView());
        HomeViewModelFactory factory = new HomeViewModelFactory(new TMDBRepositoryIMPL());
        homeViewModel = new ViewModelProvider(this, factory).get(HomeViewModel.class);

        homeViewModel.getTrendingMovies();
        homeViewModel.getTrendingMoviesLiveData().observe(getViewLifecycleOwner(), movies -> {

            MovieAdapter adapter = new MovieAdapter(movies, this);

            requireActivity().runOnUiThread(() -> {
                binding.homeFragmentRV.setAdapter(adapter);
            });
        });

    }

    @Override
    public void onMovieClicked(int movieID) {
        Log.d("last", "onMovieClicked: ");
    }
}