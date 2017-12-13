package com.sandeepshabd.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.presenter.MovieListingPresenter;


/*
* This class will show the movie listings based on popularity
* */
public class MovieListingActivity extends BaseActivity {

    private static final String TAG = MovieListingActivity.class.getSimpleName();
    public static final String MOVIE_DATA = "MOVIE_DATA";
    private MovieListingPresenter movieListingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_listing);
        String movieData = getIntent().getStringExtra(MOVIE_DATA);
        movieListingPresenter = new MovieListingPresenter(this);
        movieListingPresenter.parseMovieData(movieData);
    }
}
