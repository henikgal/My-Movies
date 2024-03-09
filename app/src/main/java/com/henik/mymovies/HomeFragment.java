package com.henik.mymovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.henik.mymovies.databinding.FragmentHomeBinding;
import com.henik.mymovies.retrofit.Movie;
import com.henik.mymovies.retrofit.MovieAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                "the mostest bested halastra jorlalya of them all in mafaranda land 6"
                ,"www.halastar.com"
                ,"4.5"
                ,"300"
                ,"17,7,2006"
        ));
        movies.add(new Movie(
                "the mostest bested halastra jorlalya of them all in mafaranda land 6"
                ,"www.halastar.com"
                ,"3.5"
                ,"140"
                ,"21,4,2009"
        ));
        MovieAdapter adapter = new MovieAdapter(movies);
        binding.homeFragmentRV.setAdapter(adapter);

    }
}