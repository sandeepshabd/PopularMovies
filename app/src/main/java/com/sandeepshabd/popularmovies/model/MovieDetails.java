package com.sandeepshabd.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * The class will contain the details of the movie.
 *
 * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies"> GET Popular Movie</a>
 */

public class MovieDetails {

    final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    final SimpleDateFormat dateFormatUS = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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


    public float getPopularity() {
        try {
            popularity = Float.valueOf(decimalFormat.format(popularity));
        } catch (Exception e) {
        }
        return popularity;

    }

    public String getReleaseDate() {
        try {
            Date date = dateFormat.parse(releaseDate);
            releaseDate = dateFormatUS.format(date);
        } catch (Exception e) {
        }
        return releaseDate;
    }


}
