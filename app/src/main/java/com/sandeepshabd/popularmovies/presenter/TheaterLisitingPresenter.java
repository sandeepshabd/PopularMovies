package com.sandeepshabd.popularmovies.presenter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.ErrorActivity;
import com.sandeepshabd.popularmovies.activity.ITheaterdataFetcher;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.helper.VolleyRequestHelper;
import com.sandeepshabd.popularmovies.model.theater.MovieAndTheaters;
import com.sandeepshabd.popularmovies.model.theater.MovieTheaters;
import com.sandeepshabd.popularmovies.model.theater.Showtimes;
import com.sandeepshabd.popularmovies.model.theater.TheaterAndTimings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import hugo.weaving.DebugLog;


/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterLisitingPresenter implements VolleyRequestHelper.IVolleyReponseConsumer {
    private static final String TAG = TheaterLisitingPresenter.class.getSimpleName();
    private final Gson gson = new Gson();

    private final static String LAT_STRING = "‎42.348495";
    private final static String LNG_STRING = "-83.060303";

    private String movieTitleLocal = "";
    private MovieAndTheaters movieAndTheaters = new MovieAndTheaters();
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    final Date date = new Date();

    ITheaterdataFetcher theaterdataFetcher;

    //TODO - for demo, I am not changing the data as frequently.


    public TheaterLisitingPresenter(ITheaterdataFetcher theaterdataFetcher) {
        this.theaterdataFetcher = theaterdataFetcher;
    }

    public void startFetchingTheaterData(String movieTitle) {
        movieTitleLocal = movieTitle;
        boolean locationSame = false;
        Location myLocation = getLocation();

        if (movieAndTheaters == null
                || movieAndTheaters.movieTheaterList == null
                || movieAndTheaters.movieTheaterList.length == 0) {
            if (myLocation == null) {
                startFetchingMovieData(LAT_STRING, LNG_STRING);
            } else {
                startFetchingMovieData(myLocation.getLatitude() + "", myLocation.getLongitude() + "");
            }
            startFetchingMovieData(LAT_STRING, LNG_STRING);
        } else {
            filterDataAndCallSuccess();
        }

    }

    private void filterDataAndCallSuccess() {
        ArrayList<TheaterAndTimings> theaterAndTimingsList = new ArrayList<>();
        Log.i(TAG, "startFetchingTheaterData: " + theaterAndTimingsList.size());
        if (movieAndTheaters != null &&
                movieAndTheaters.movieTheaterList != null
                && movieAndTheaters.movieTheaterList.length > 0) {
            for (MovieTheaters movieTheaters : movieAndTheaters.movieTheaterList) {
                if (movieTitleLocal.trim().equalsIgnoreCase(movieTheaters.title.trim())) {
                    Log.i(TAG, "filterDataAndCallSuccess: found ");
                    for (Showtimes showtimes : movieTheaters.showtimes) {
                        TheaterAndTimings theaterAndTimings = new TheaterAndTimings();
                        theaterAndTimings.movieTheater = showtimes.theater.theaterName;
                        theaterAndTimings.movieTiming = showtimes.getShowTime();
                        theaterAndTimingsList.add(theaterAndTimings);
                    }

                }

            }
        } else {
            Log.i(TAG, "filterDataAndCallSuccess: movieTheaterList is empty.");
        }
        Log.i(TAG, "filterDataAndCallSuccess: '" + theaterAndTimingsList.size());
        if (theaterAndTimingsList.size() == 0) {
            TheaterAndTimings theaterAndTimings = new TheaterAndTimings();
            theaterAndTimings.movieTheater = theaterdataFetcher.getContext().getString(R.string.NoMovieTheater);
            theaterAndTimingsList.add(theaterAndTimings);
        }

        theaterdataFetcher.onTheaterDataFecthed(theaterAndTimingsList);
    }

    @DebugLog
    public void startFetchingMovieData(String lat, String lng) {
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        movieAndTheaters.latitude = lat;
        movieAndTheaters.longitude = lng;
        volleyRequestHelper.makeVolleyGetRequest(theaterdataFetcher.getContext(),
                BackOfficeDetails.getNMovieTheaters(dateFormat.format(date),
                        lat, lng), this);
    }


    private Location getLocation() {
        boolean gps_enabled = false;
        boolean network_enabled = false;

        LocationManager lm = (LocationManager) theaterdataFetcher.getContext()
                .getSystemService(Context.LOCATION_SERVICE);

        gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Location net_loc = null, gps_loc = null, finalLoc = null;
        try {


            if (ActivityCompat.checkSelfPermission(theaterdataFetcher.getContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(theaterdataFetcher.getContext(),
                            Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                if (gps_enabled)
                    gps_loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (network_enabled)
                    net_loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }

        } catch (Exception e) {
        }

        if (gps_loc != null && net_loc != null) {

            //smaller the number more accurate result will
            if (gps_loc.getAccuracy() > net_loc.getAccuracy())
                finalLoc = net_loc;
            else
                finalLoc = gps_loc;

            // I used this just to get an idea (if both avail, its upto you which you want to take as I've taken location with more accuracy)

        } else {

            if (gps_loc != null) {
                finalLoc = gps_loc;
            } else if (net_loc != null) {
                finalLoc = net_loc;
            }
        }

        return finalLoc;
    }

    @Override
    public void onSuccessResponse(String response) {
        parseTheaterData(response);
    }

    private void parseTheaterData(String response) {

        try {
            movieAndTheaters.movieTheaterList = gson.fromJson(response, MovieTheaters[].class);
            Log.i(TAG, "parseTheaterData: " + movieAndTheaters.movieTheaterList.length);
        } catch (Exception e) {
            Log.e(TAG, "problem parsing data", e);
        }
        filterDataAndCallSuccess();
    }

    @Override
    public void onErrorReponse(VolleyError volleyError) {
        showErrorMessage();
    }

    private void showErrorMessage() {
        Intent errorIntent = new Intent(theaterdataFetcher.getContext(), ErrorActivity.class);
        theaterdataFetcher.getContext().startActivity(errorIntent);
        theaterdataFetcher.finishTheActivity();
    }
}
