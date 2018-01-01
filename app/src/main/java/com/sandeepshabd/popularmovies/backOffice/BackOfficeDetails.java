package com.sandeepshabd.popularmovies.backOffice;

import android.text.TextUtils;

import hugo.weaving.DebugLog;

import static com.sandeepshabd.popularmovies.BuildConfig.OPEN_MOVIE_API;

/**
 * The class will provide the details for back office URLS.
 */

public class BackOfficeDetails {

    //Provides the base url. It can be pointed to localhost if a fake server is used to
    //mock the BO.
    final private static String BASE_URL = "https://api.themoviedb.org/3";
    final private static String BASE_IMG_PATH = "https://image.tmdb.org/t/p/w500";
    final private static String API_KEY_FOR_OPENMOVIE = ""; //input your key here.
    final private static String POPULAR_URL = "/movie/popular?api_key=";
    final private static String NOWPLAYING_URL = "/movie/now_playing?api_key=";


    // The method returns the uri for popular movie
    @DebugLog
    public static String getPopularMoviesURL(int page) {
        if (TextUtils.isEmpty(API_KEY_FOR_OPENMOVIE)) {
            //enforcing the developer to input the API key.
            throw new RuntimeException("API KEY cannot be empty.");
        }
        return BASE_URL + POPULAR_URL + API_KEY_FOR_OPENMOVIE + "&language=en-US&page=" + page;
    }

    @DebugLog
    public static String getNowplayingUrlURL(int page) {
        if (TextUtils.isEmpty(API_KEY_FOR_OPENMOVIE)) {
            //enforcing the developer to input the API key.
            throw new RuntimeException("API KEY cannot be empty.");
        }
        return BASE_URL + NOWPLAYING_URL + API_KEY_FOR_OPENMOVIE + "&language=en-US&page=" + page ;
    }

    @DebugLog
    public static String getImagePathURL(String uri) {
        //eg. https://image.tmdb.org/t/p/w500/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg
        return BASE_IMG_PATH + uri;
    }


}
