package com.sandeepshabd.popularmovies.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.MovieListingAdapter;
import com.sandeepshabd.popularmovies.model.MovieResponse;
import com.sandeepshabd.popularmovies.presenter.MovieListingPresenter;

import hugo.weaving.DebugLog;


/*
* This class will show the movie listings based on popularity
* */
public class MovieListingActivity extends BaseActivity implements IMovieDataFetcher, IMovieListingInvoker {

    private static final String TAG = MovieListingActivity.class.getSimpleName();
    public static final String MOVIE_DATA = "MOVIE_DATA";
    private MovieListingPresenter movieListingPresenter;
    private int pageCount = 1; //initialize the page count to 1.
    private RecyclerView movieListingRecyclerView;
    private MovieResponse movieResponse;
    private ImageButton aboutInfoButton;
    private MovieListingAdapter movieListingAdapter;
    private SpinnerDialog spinnerDialog;


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
        LinearLayoutManager llm = new LinearLayoutManager(this);
        movieListingRecyclerView.setLayoutManager(llm);
        movieListingRecyclerView.setHasFixedSize(false);

        movieListingAdapter
                = new MovieListingAdapter(Glide.with(this)
                , movieResponse.movieDetailsList, this);
        movieListingRecyclerView.setAdapter(movieListingAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeSpinner();

    }


    @Override
    public void fetchMoreData() {
        spinnerDialog = new SpinnerDialog(this);
        spinnerDialog.show();
        movieListingPresenter.startFetchingMovieData(pageCount);
        pageCount++;
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
        }catch (Exception e){
            Log.e(TAG, "updateMovieListing: hiding spinner exception.");
        }
    }


}
