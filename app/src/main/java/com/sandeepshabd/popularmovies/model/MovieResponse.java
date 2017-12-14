package com.sandeepshabd.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * This is the reponse object that we get on GET call to the Movie Database.
 *
 * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies"> GET Popular Movie</a>
 */

public class MovieResponse {

    @SerializedName("page")
    public int page;

    @SerializedName("totalResult")
    public int totalResult;

    @SerializedName("totalPages")
    public int totalPages;

    @SerializedName("results")
    public ArrayList<MovieDetails> movieDetailsList = new ArrayList<>(); //in case there is no data.

}
