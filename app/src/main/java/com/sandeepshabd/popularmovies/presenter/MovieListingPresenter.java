package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sandeepshabd.popularmovies.activity.ErrorActivity;
import com.sandeepshabd.popularmovies.activity.IMovieListingInvoker;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.helper.VolleyRequestHelper;
import com.sandeepshabd.popularmovies.model.MovieResponse;

import hugo.weaving.DebugLog;

/**
 * The class is presenter to the MovieListing activity.
 */

public class MovieListingPresenter implements VolleyRequestHelper.IVolleyReponseConsumer {
    private static final String TAG = MovieListingPresenter.class.getSimpleName();
    private final Gson gson = new Gson();
    private IMovieListingInvoker movieListingInvoker;

    public MovieListingPresenter(IMovieListingInvoker movieListingInvoker) {
        this.movieListingInvoker = movieListingInvoker;
    }

    @DebugLog
    public MovieResponse parseMovieData(String movieData) {
        MovieResponse movieResponse;
        try {
            movieResponse = gson.fromJson(movieData, MovieResponse.class);
            Log.i(TAG, "parseMovieData: movie list size:" + movieResponse.movieDetailsList.size());
        } catch (Exception e) {
            Log.e(TAG, "problem parsing data", e);
            movieResponse = new MovieResponse();
            showErrorMessage();
        }
        return movieResponse;
    }

    @DebugLog
    public void startFetchingMovieData(int pageNumber) {
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        volleyRequestHelper.makeVolleyGetRequest(movieListingInvoker.getActivityContext(),
                BackOfficeDetails.getPopularMoviesURL(pageNumber + 1),
                this);
    }

    @Override
    public void onSuccessResponse(String response) {
        movieListingInvoker.updateMovieListing(parseMovieData(response));
    }

    @Override
    public void onErrorReponse(VolleyError volleyError) {
        showErrorMessage();
    }

    private void showErrorMessage() {
        Intent errorIntent = new Intent(movieListingInvoker.getActivityContext(), ErrorActivity.class);
        movieListingInvoker.getActivityContext().startActivity(errorIntent);
        movieListingInvoker.finishTheActivity();
    }
}
