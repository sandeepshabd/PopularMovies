package com.sandeepshabd.popularmovies.backOffice;

/**
 * The class will provide the details for back office URLS.
 */

public class BackOfficeDetails {

    //Provides the base url. It can be pointed to localhost if a fake server is used to
    //mock the BO.
    final private static String BASE_URL = "https://api.themoviedb.org/3";


    // The method returns the uri for popular movie
    public static String getPopularMoviesURL(String apiKey, int page) {
        return BASE_URL + "/movie/popular?api_key=" + apiKey + "&language=en-US&page=" + page;
    }


}
