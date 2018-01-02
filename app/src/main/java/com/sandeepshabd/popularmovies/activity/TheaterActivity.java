package com.sandeepshabd.popularmovies.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.adapter.TheaterListingAdapter;
import com.sandeepshabd.popularmovies.model.TheaterAndTimings;
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

        setTitle(R.string.theater);
        movieListingToolbar.setNavigationIcon(R.mipmap.ic_navigate_before_black_24dp);
        movieListingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        theaterRecyclerView = findViewById(R.id.theaterListingRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        theaterRecyclerView.setLayoutManager(llm);
        theaterRecyclerView.setHasFixedSize(false);

        theaterListingAdapter = new TheaterListingAdapter(this, new ArrayList<TheaterAndTimings>());
        theaterRecyclerView.setAdapter(theaterListingAdapter);
        theaterLisitingPresenter = new TheaterLisitingPresenter(this);

        fetchTheaterData( getIntent().getStringExtra(MOVIE_TITLE));


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
        }catch (Exception e){
            Log.e(TAG, "updateMovieListing: hiding spinner exception.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeSpinner();

    }



}
