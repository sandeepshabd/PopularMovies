package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.sandeepshabd.popularmovies.model.MovieResponse;

import hugo.weaving.DebugLog;

/**
 * The class is presenter to the MovieListing activity.
 */

public class MovieListingPresenter {
    private static final String TAG = MovieListingPresenter.class.getSimpleName();

    private Context context;

    public MovieListingPresenter(Context context) {
        this.context = context;
    }

    @DebugLog
    public MovieResponse parseMovieData(String movieData) {
        Gson gson = new Gson();
        MovieResponse movieResponse = gson.fromJson(movieData, MovieResponse.class);
        Log.i(TAG, "parseMovieData: movie list size:" + movieResponse.movieDetailsList.size());
        return movieResponse;
    }
}
