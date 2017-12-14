package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.MovieListingAdapter;
import com.sandeepshabd.popularmovies.model.MovieResponse;
import com.sandeepshabd.popularmovies.presenter.MovieListingPresenter;

import hugo.weaving.DebugLog;


/*
* This class will show the movie listings based on popularity
* */
public class MovieListingActivity extends BaseActivity {

    private static final String TAG = MovieListingActivity.class.getSimpleName();
    public static final String MOVIE_DATA = "MOVIE_DATA";
    private MovieListingPresenter movieListingPresenter;
    private int pageCount = 1; //initialize the page count to 1.
    private RecyclerView movieListingRecyclerView;
    private MovieResponse movieResponse;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_listing);
        String movieData = getIntent().getStringExtra(MOVIE_DATA);
        movieListingPresenter = new MovieListingPresenter(this);
        movieResponse = movieListingPresenter.parseMovieData(movieData);
        movieListingRecyclerView = findViewById(R.id.movieListingRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        movieListingRecyclerView.setLayoutManager(llm);
        movieListingRecyclerView.setHasFixedSize(false);
        MovieListingAdapter movieListingAdapter
                = new MovieListingAdapter(Glide.with(getApplicationContext())
                , movieResponse.movieDetailsList);
        movieListingRecyclerView.setAdapter(movieListingAdapter);
    }
}
