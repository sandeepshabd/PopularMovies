package com.sandeepshabd.popularmovies.backOffice;

import hugo.weaving.DebugLog;

/**
 * The class will provide the details for back office URLS.
 */

public class BackOfficeDetails {

    //Provides the base url. It can be pointed to localhost if a fake server is used to
    //mock the BO.
    final private static String BASE_URL = "https://api.themoviedb.org/3";
    final private static String BASE_IMG_PATH = "https://image.tmdb.org/t/p/w500";
    final private static String API_KEY = "";


    // The method returns the uri for popular movie
    @DebugLog
    public static String getPopularMoviesURL(int page) {
        return BASE_URL + "/movie/popular?api_key=" + API_KEY + "&language=en-US&page=" + page;
    }

    @DebugLog
    public static String getImagePathURL(String uri){
        //eg. https://image.tmdb.org/t/p/w500/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg
        return BASE_IMG_PATH + uri.substring(1);
    }


}
