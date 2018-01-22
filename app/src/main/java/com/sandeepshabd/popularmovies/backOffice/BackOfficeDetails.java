package com.sandeepshabd.popularmovies.backOffice;

import android.text.TextUtils;

import hugo.weaving.DebugLog;

/**
 * The class will provide the details for back office URLS.
 */

public class BackOfficeDetails {

    //Provides the base url. It can be pointed to localhost if a fake server is used to
    //mock the BO.
    //open m0vie details
    final private static String API_KEY_FOR_OPENMOVIE = "71adffcb631e5befc6b880ca18d29e09"; //input your key here.
    final private static String BASE_IMG_PATH = "https://image.tmdb.org/t/p/w500";
    final private static String BASE_URL_FOR_OPENMOVIE = "https://api.themoviedb.org/3";
    final private static String POPULAR_URL_FOR_OPENMOVIE = "/movie/popular?api_key=";
    final private static String NOWPLAYING_URL_FOR_OPENMOVIE = "/movie/now_playing?api_key=";

    //http://developer.tmsapi.com/
    final private static String API_KEY_FOR_TMS = "qyg6bv47fvaznqppw4544nq2"; //input your key here.
    final private static String BASE_URL_FOR_MS = "http://data.tmsapi.com";
    final private static String THEATERS_URL_FOR_MS = "/v1.1/movies/showings?api_key=";



    // The method returns the uri for popular movie
    @DebugLog
    public static String getPopularMoviesURL(int page) {
        if (TextUtils.isEmpty(API_KEY_FOR_OPENMOVIE)) {
            //enforcing the developer to input the API key.
            throw new RuntimeException("API KEY cannot be empty.");
        }
        return BASE_URL_FOR_OPENMOVIE + POPULAR_URL_FOR_OPENMOVIE + API_KEY_FOR_OPENMOVIE + "&language=en-US&page=" + page;
    }

    @DebugLog
    public static String getNowplayingUrlURL(int page) {
        if (TextUtils.isEmpty(API_KEY_FOR_OPENMOVIE)) {
            //enforcing the developer to input the API key.
            throw new RuntimeException("API KEY cannot be empty.");
        }
        return BASE_URL_FOR_OPENMOVIE + NOWPLAYING_URL_FOR_OPENMOVIE + API_KEY_FOR_OPENMOVIE + "&language=en-US&page=" + page ;
    }

    @DebugLog
    public static String getNMovieTheaters(String date, String zip) {
        if (TextUtils.isEmpty(API_KEY_FOR_OPENMOVIE)) {
            //enforcing the developer to input the API key.
            throw new RuntimeException("API KEY cannot be empty.");
        }
        return BASE_URL_FOR_MS + THEATERS_URL_FOR_MS + API_KEY_FOR_TMS + "&startDate="+date+"&zip="+zip;
    }

    @DebugLog
    public static String getImagePathURL(String uri) {
        //eg. https://image.tmdb.org/t/p/w500/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg
        return BASE_IMG_PATH + uri;
    }


}
