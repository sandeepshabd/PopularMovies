package com.sandeepshabd.popularmovies.activity;

/**
 * This callback gets invoked to fetch more data from BO.
 */

public interface IMovieDataFetcher {
    void fetchMoreData();
    void onMovieSelected(String title);
}
