package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.content.Intent;

import com.android.volley.VolleyError;
import com.sandeepshabd.popularmovies.activity.ErrorActivity;
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

    private Context context;

    private SplashPresenter(){}

    public SplashPresenter(Context context){
        this.context = context;
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
        Intent movieListingIntent = new Intent(context, MovieListingActivity.class);
        movieListingIntent.putExtra(MovieListingActivity.MOVIE_DATA,response );
        context.startActivity(movieListingIntent);
    }

    @DebugLog
    @Override
    public void onErrorReponse(VolleyError volleyError) {
        // call errorActivity
        Intent errorIntent = new Intent(context, ErrorActivity.class);
        context.startActivity(errorIntent);
    }

    @DebugLog
    public void startFetchingMovieData() {
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        volleyRequestHelper.makeVolleyGetRequest(context,
                BackOfficeDetails.getPopularMoviesURL(1),
                this);
    }
}
