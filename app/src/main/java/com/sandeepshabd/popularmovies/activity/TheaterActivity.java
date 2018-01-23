package com.sandeepshabd.popularmovies.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.TheaterListingAdapter;
import com.sandeepshabd.popularmovies.model.MovieData;
import com.sandeepshabd.popularmovies.model.theater.TheaterAndTimings;
import com.sandeepshabd.popularmovies.presenter.TheaterLisitingPresenter;

import java.util.ArrayList;

public class TheaterActivity extends AppCompatActivity implements ITheaterView, ITheaterdataFetcher {

    private static final String TAG = TheaterActivity.class.getSimpleName();
    public static final String MOVIE_TITLE = "MOVIE_TITLE";
    private SpinnerDialog spinnerDialog;
    private TheaterLisitingPresenter theaterLisitingPresenter;
    private RecyclerView theaterRecyclerView;
    private TheaterListingAdapter theaterListingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);
        Toolbar movieListingToolbar = findViewById(R.id.theaterListing_toolbar);
        setSupportActionBar(movieListingToolbar);

        MovieData movieData = getIntent().getExtras().getParcelable("movie_data");
        Log.i(TAG, "onCreate: " + movieData);
        String movieTitle = getIntent().getStringExtra(MOVIE_TITLE);
        setTitle(movieTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        movieListingToolbar.setNavigationIcon(R.mipmap.ic_navigate_before_black_24dp);
//        movieListingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        theaterRecyclerView = findViewById(R.id.theaterListingRecyclerView);
        theaterRecyclerView.setHasFixedSize(true);

        theaterListingAdapter = new TheaterListingAdapter(this, new ArrayList<TheaterAndTimings>(), movieData);
        theaterRecyclerView.setAdapter(theaterListingAdapter);
        theaterLisitingPresenter = new TheaterLisitingPresenter(this);

        fetchTheaterData(movieTitle);

        ImageView imageView = findViewById(R.id.backdrop);
        String url = getIntent().getStringExtra("movie_url");
        Glide.with(this)
                .asBitmap()
                .load(url)
                .into(imageView);

        TextView movieText = findViewById(R.id.movie_info);
        movieText.setText(movieData.getTitle());

        TextView movieDescription = findViewById(R.id.movie_description);
        movieDescription.setText(movieData.getShortDescription());

        TextView movieCast = findViewById(R.id.movie_cast);
        StringBuilder castString = new StringBuilder();
        for (String cast : movieData.getTopCast()) {
            castString.append(cast);
            castString.append("\n");
        }

        movieCast.setText(castString.toString());

    }

    public void fetchTheaterData(String movieTitle) {
        spinnerDialog = new SpinnerDialog(this);
        spinnerDialog.show();
        theaterLisitingPresenter.startFetchingTheaterData(movieTitle);
    }

    @Override
    public void onTheaterDataFecthed(ArrayList<TheaterAndTimings> theaterTimingList) {
        theaterListingAdapter.addDataToList(theaterTimingList);
        closeSpinner();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onTheaterSelected(String title) {
        //TODO: add ability to go to movies and book tickets.
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
    protected void onDestroy() {
        super.onDestroy();
        closeSpinner();
    }

    @Override
    public void finishTheActivity() {
        finish();
    }

}
