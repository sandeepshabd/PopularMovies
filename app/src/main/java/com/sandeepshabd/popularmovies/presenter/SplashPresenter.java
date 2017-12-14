package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.content.Intent;

import com.android.volley.VolleyError;
import com.sandeepshabd.popularmovies.activity.ErrorActivity;
import com.sandeepshabd.popularmovies.activity.ISplashInvoker;
import com.sandeepshabd.popularmovies.activity.MovieListingActivity;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.helper.VolleyRequestHelper;

import java.util.Timer;
import java.util.TimerTask;

import hugo.weaving.DebugLog;


/**
 * This class is the presenter class to the Splash activity.
 */

public class SplashPresenter implements VolleyRequestHelper.IVolleyReponseConsumer {

    private ISplashInvoker splashInvoker;

    private SplashPresenter() {
    }

    public SplashPresenter(ISplashInvoker splashInvoker) {
        this.splashInvoker = splashInvoker;
    }

    @DebugLog
    @Override
    public void onSuccessResponse(final String response) {
        // call movieListActivity

        //A small delay to show splash activity
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        callMovieListing(response);
                    }
                },
                1000
        );

    }

    @DebugLog
    private void callMovieListing(String response) {
        Intent movieListingIntent = new Intent(splashInvoker.getActivityContext(), MovieListingActivity.class);
        movieListingIntent.putExtra(MovieListingActivity.MOVIE_DATA, response);
        splashInvoker.getActivityContext().startActivity(movieListingIntent);
        splashInvoker.finishTheActivity();
    }

    @DebugLog
    @Override
    public void onErrorReponse(VolleyError volleyError) {
        // call errorActivity
        Intent errorIntent = new Intent(splashInvoker.getActivityContext(), ErrorActivity.class);
        splashInvoker.getActivityContext().startActivity(errorIntent);
        splashInvoker.finishTheActivity();
    }

    @DebugLog
    public void startFetchingMovieData() {
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        volleyRequestHelper.makeVolleyGetRequest(splashInvoker.getActivityContext(),
                BackOfficeDetails.getPopularMoviesURL(1),
                this);
    }
}
