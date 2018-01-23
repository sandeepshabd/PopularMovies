package com.sandeepshabd.popularmovies.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.MovieListingAdapter;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.helper.VolleyRequestHelper;
import com.sandeepshabd.popularmovies.model.MovieData;
import com.sandeepshabd.popularmovies.model.MovieResponse;
import com.sandeepshabd.popularmovies.presenter.MovieListingPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hugo.weaving.DebugLog;


/*
 * This class will show the movie listings based on popularity
 * */
public class MovieListingActivity extends BaseActivity implements IMovieDataFetcher, IMovieListingInvoker, VolleyRequestHelper.IVolleyReponseConsumer {

    private static final String TAG = MovieListingActivity.class.getSimpleName();
    public static final String MOVIE_DATA = "MOVIE_DATA";
    private MovieListingPresenter movieListingPresenter;
    private int pageCount = 1; //initialize the page count to 1.
    private RecyclerView movieListingRecyclerView;
    private MovieResponse movieResponse;
    private ImageButton aboutInfoButton;
    private MovieListingAdapter movieListingAdapter;
    private SpinnerDialog spinnerDialog;
    private List<MovieData> movieDataList = new ArrayList<>();

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_listing);
        Toolbar movieListingToolbar = findViewById(R.id.movieListing_toolbar);
        setSupportActionBar(movieListingToolbar);
        movieListingToolbar.setTitle(R.string.popular_movies);

        aboutInfoButton = findViewById(R.id.showAbout);
        aboutInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showAboutScreen = new Intent(getActivityContext(), AboutActivity.class);
                getActivityContext().startActivity(showAboutScreen);
            }
        });
        String movieData = getIntent().getStringExtra(MOVIE_DATA);
        movieListingPresenter = new MovieListingPresenter(this);
        movieResponse = movieListingPresenter.parseMovieData(movieData);

        movieListingRecyclerView = findViewById(R.id.movieListingRecyclerView);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        movieListingRecyclerView.setLayoutManager(llm);
        movieListingRecyclerView.setHasFixedSize(true);

        movieListingAdapter
                = new MovieListingAdapter(Glide.with(this)
                , movieResponse.movieDetailsList, this);
        movieListingRecyclerView.setAdapter(movieListingAdapter);

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Date date = new Date();
        Log.i(TAG, "onCreate: " + dateFormat.format(date));
        VolleyRequestHelper volleyRequestHelper = new VolleyRequestHelper();
        volleyRequestHelper.makeVolleyGetRequest(this,
                BackOfficeDetails.getNMovieTheaters(dateFormat.format(date), "48127"),
                this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    @DebugLog
    protected void onDestroy() {
        super.onDestroy();
        closeSpinner();
    }

    @Override
    @DebugLog
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void fetchMoreData() {
        spinnerDialog = new SpinnerDialog(this);
        spinnerDialog.show();
        movieListingPresenter.startFetchingMovieData(pageCount);
        pageCount++;
    }

    @Override
    public void onMovieSelected(String title, String url) {
        Intent myIntent = new Intent(MovieListingActivity.this, TheaterActivity.class);
        myIntent.putExtra(TheaterActivity.MOVIE_TITLE, title); //Optional parameters
        MovieData movieData = new MovieData();
        Log.d(TAG, "onMovieSelected: " + movieDataList);
        for (MovieData moviedata : movieDataList) {
            if (moviedata.getTitle().equalsIgnoreCase(title)) {
                movieData = moviedata;
                Log.i(TAG, "onMovieSelected: " + moviedata.getTitle());
            }
        }
        myIntent.putExtra("movie_url", url);
        myIntent.putExtra("movie_data", movieData);
        MovieListingActivity.this.startActivity(myIntent);
    }

    @Override
    public void finishTheActivity() {
        finish();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void updateMovieListing(MovieResponse movieReponseData) {
        closeSpinner();
        movieListingAdapter.addDataToList(movieReponseData.movieDetailsList);
        Toast.makeText(MovieListingActivity.this,
                R.string.pleaseScroll, Toast.LENGTH_LONG).show();
    }

    private void closeSpinner() {
        try {
            spinnerDialog.hide();
            spinnerDialog = null;
        } catch (Exception e) {
            Log.e(TAG, "updateMovieListing: hiding spinner exception.");
        }
    }


    @Override
    public void onSuccessResponse(String response) {
        Log.i(TAG, "onSuccessResponse: " + response);
        if (!response.isEmpty()) {
            parseMovieData(response);
        } else {
            Log.i(TAG, "Response is empty: ");
        }
    }

    @Override
    public void onErrorReponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorReponse: ", volleyError);
    }

    public void parseMovieData(String movieData) {
        try {
            movieDataList = new Gson().fromJson(movieData, new TypeToken<List<MovieData>>() {
            }.getType());
            Log.d(TAG, "parseMovieData: " + movieDataList);
        } catch (Exception e) {
            Log.e(TAG, "problem parsing data", e);
        }
    }
}
