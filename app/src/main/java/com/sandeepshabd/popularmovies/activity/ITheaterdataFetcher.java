package com.sandeepshabd.popularmovies.activity;

import com.sandeepshabd.popularmovies.model.TheaterAndTimings;

import java.util.ArrayList;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public interface ITheaterdataFetcher {

    void onTheaterDataFecthed(ArrayList<TheaterAndTimings> theaterTimingList);
}
