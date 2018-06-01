package com.sandeepshabd.popularmovies.activity;

import android.widget.ImageView;

/**
 * This callback gets invoked to fetch more data from BO.
 */

public interface IMovieDataFetcher {
    void fetchMoreData();
    void onMovieSelected(String title, String url, ImageView moviePoster);
}
