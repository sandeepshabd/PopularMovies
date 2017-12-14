package com.sandeepshabd.popularmovies.activity;

import android.content.Context;

import com.sandeepshabd.popularmovies.model.MovieResponse;

/**
 * The presenter invokes the Acvity using this callback
 */

public interface IMovieListingInvoker {

    void finishTheActivity();
    Context getActivityContext();
    void updateMovieListing(MovieResponse movieReponseData);

}
