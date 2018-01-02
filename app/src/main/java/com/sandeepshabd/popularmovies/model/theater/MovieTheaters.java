package com.sandeepshabd.popularmovies.model.theater;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class MovieTheaters {

    @SerializedName("title")
    public String title;

    @SerializedName("showtimes")
    public List<Showtimes> showtimes;
}
