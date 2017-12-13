package com.sandeepshabd.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is the reponse object that we get on GET call to the Movie Database.
 * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies"> GET Popular Movie</a>
 */

public class MovieResponse {

    @SerializedName("page")
    int page;

    @SerializedName("totalResult")
    int totalResult;

    @SerializedName("totalPages")
    int totalPages;

    @SerializedName("results")
    List<MovieDetails> movieDetailsList;

}
