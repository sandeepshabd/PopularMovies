package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.content.Intent;

import com.android.volley.VolleyError;
import com.sandeepshabd.popularmovies.activity.ErrorActivity;
import com.sandeepshabd.popularmovies.activity.MovieListingActivity;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.helper.VolleyRequestHelper;


/**
 * This class is the presenter class to the Splash activity.
 */

public class SplashPresenter implements VolleyRequestHelper.IVolleyReponseConsumer {

    private Context context;

    private SplashPresenter(){}

    public SplashPresenter(Context context){
        this.context = context;
    }

    @Override
    public void onSuccessResponse(String response) {
        // call movieListActivity
        Intent errorIntent = new Intent(context, MovieListingActivity.class);
        errorIntent.putExtra(MovieListingActivity.MOVIE_DATA,response );
        context.startActivity(errorIntent);
    }

    @Override
    public void onErrorReponse(VolleyError volleyError) {
        // call errorActivity
        Intent errorIntent = new Intent(context, ErrorActivity.class);
        context.startActivity(errorIntent);
    }

    public void startFetchingMovieData() {
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        volleyRequestHelper.makeVolleyGetRequest(context,
                BackOfficeDetails.getPopularMoviesURL(1),
                this);
    }
}
