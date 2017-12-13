package com.sandeepshabd.popularmovies.model;

import com.google.gson.annotations.SerializedName;

/**
 * The class will contain the details of the movie.
 *
 * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies"> GET Popular Movie</a>
 */

class MovieDetails {

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("adult")
    public boolean totalResult;

    @SerializedName("overview")
    public String overview;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("id")
    public int id;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("title")
    public String title;

    @SerializedName("backdrop_path")
    public String backdropPath;

    @SerializedName("popularity")
    public float popularity;

    @SerializedName("vote_count")
    public int voteCount;

    @SerializedName("video")
    public boolean video;

    @SerializedName("vote_average")
    public float voteAverage;


}
