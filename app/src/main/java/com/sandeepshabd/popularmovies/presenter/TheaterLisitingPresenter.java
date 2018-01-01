package com.sandeepshabd.popularmovies.presenter;

import com.sandeepshabd.popularmovies.activity.ITheaterdataFetcher;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterLisitingPresenter {

    ITheaterdataFetcher theaterdataFetcher;

    public TheaterLisitingPresenter(ITheaterdataFetcher theaterdataFetcher){
        this.theaterdataFetcher = theaterdataFetcher;
    }

    public void startFetchingTheaterData(String movieTitle) {


    }
}
