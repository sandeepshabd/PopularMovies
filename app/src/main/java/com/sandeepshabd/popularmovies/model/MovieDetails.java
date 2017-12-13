package com.sandeepshabd.popularmovies.model;

import com.google.gson.annotations.SerializedName;

/**
 * The class will contain the details of the movie.
 *  @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies"> GET Popular Movie</a>
 */

class MovieDetails {

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("adult")
    boolean totalResult;

    @SerializedName("overview")
    String overview;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("id")
    int id;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("title")
    String title;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("popularity")
    float popularity;

    @SerializedName("vote_count")
    int voteCount;

    @SerializedName("video")
    boolean video;

    @SerializedName("vote_average")
    float  voteAverage;


}
