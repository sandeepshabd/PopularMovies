package com.sandeepshabd.popularmovies.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


import com.bumptech.glide.Glide;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.MovieListingAdapter;
import com.sandeepshabd.popularmovies.model.MovieResponse;
import com.sandeepshabd.popularmovies.presenter.MovieListingPresenter;

import hugo.weaving.DebugLog;


/*
* This class will show the movie listings based on popularity
* */
public class MovieListingActivity extends BaseActivity {

    private static final String TAG = MovieListingActivity.class.getSimpleName();
    public static final String MOVIE_DATA = "MOVIE_DATA";
    private Context context ;
    private MovieListingPresenter movieListingPresenter;
    private int pageCount = 1; //initialize the page count to 1.
    private RecyclerView movieListingRecyclerView;
    private MovieResponse movieResponse;
    private Toolbar toolbar;
    private ImageButton aboutInfoButton;


    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_movie_listing);

        Toolbar myToolbar = findViewById(R.id.movieListing_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(R.string.popular_movies);

        aboutInfoButton = findViewById(R.id.showAbout);
        aboutInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showAboutScreen = new Intent(context, AboutActivity.class);
                context.startActivity(showAboutScreen);
            }
        });
        String movieData = getIntent().getStringExtra(MOVIE_DATA);
        movieListingPresenter = new MovieListingPresenter(this);
        movieResponse = movieListingPresenter.parseMovieData(movieData);
        movieListingRecyclerView = findViewById(R.id.movieListingRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        movieListingRecyclerView.setLayoutManager(llm);
        movieListingRecyclerView.setHasFixedSize(false);
        MovieListingAdapter movieListingAdapter
                = new MovieListingAdapter(Glide.with(getApplicationContext())
                , movieResponse.movieDetailsList);
        movieListingRecyclerView.setAdapter(movieListingAdapter);
    }
}
