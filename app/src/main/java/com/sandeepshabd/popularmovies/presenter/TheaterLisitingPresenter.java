package com.sandeepshabd.popularmovies.presenter;

import android.util.Log;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.ITheaterdataFetcher;
import com.sandeepshabd.popularmovies.activity.TheaterActivity;
import com.sandeepshabd.popularmovies.model.TheaterAndTimings;

import java.util.ArrayList;


/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterLisitingPresenter {
    private static final String TAG = TheaterLisitingPresenter.class.getSimpleName();

    ITheaterdataFetcher theaterdataFetcher;

    public TheaterLisitingPresenter(ITheaterdataFetcher theaterdataFetcher){
        this.theaterdataFetcher = theaterdataFetcher;
    }

    public void startFetchingTheaterData(String movieTitle) {
        ArrayList<TheaterAndTimings> theaterAndTimingsList = new ArrayList<>();
        Log.i(TAG, "startFetchingTheaterData: "+theaterAndTimingsList.size());
        if(theaterAndTimingsList.size() == 0){
            TheaterAndTimings theaterAndTimings = new TheaterAndTimings();
            theaterAndTimings.movieTheater= theaterdataFetcher.getContext().getString(R.string.NoMovieTheater);
            theaterAndTimingsList.add(theaterAndTimings);
        }
        theaterdataFetcher.onTheaterDataFecthed(theaterAndTimingsList);
    }
}
