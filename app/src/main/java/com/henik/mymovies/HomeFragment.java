package com.henik.mymovies;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.henik.mymovies.databinding.FragmentHomeBinding;
import com.henik.mymovies.recycler.Movie;
import com.henik.mymovies.recycler.MovieAdapter;
import com.henik.mymovies.retrofit.TMDBResponse;
import com.henik.mymovies.retrofit.TMDBService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        retrofit.create(TMDBService.class).getTrendingMovies().enqueue(new Callback<TMDBResponse>() {
            @Override
            public void onResponse(Call<TMDBResponse> call, Response<TMDBResponse> response) {
                if (response.isSuccessful()){
                    TMDBResponse tmdbResponse = response.body();
                    Log.d("lart", "onResponse: ");
                }

            }

            @Override
            public void onFailure(Call<TMDBResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("lart", "onFailure: " );
            }
        });

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                "the mostest bested halastra jorlalya of them all in mafaranda land 6"
                ,"www.halastar.com"
                ,4.5
                ,300
                ,"17,7,2006"
        ));
        movies.add(new Movie(
                "the mostest bested halastra jorlalya of them all in mafaranda land 6"
                ,"www.halastar.com"
                ,3.5
                ,140
                ,"21,4,2009"
        ));
        MovieAdapter adapter = new MovieAdapter(movies);
        binding.homeFragmentRV.setAdapter(adapter);

    }
}