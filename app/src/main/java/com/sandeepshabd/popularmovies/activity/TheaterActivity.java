package com.sandeepshabd.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sandeepshabd.popularmovies.R;

public class TheaterActivity extends AppCompatActivity implements ITheaterView {

    public static final String MOVIE_TITLE = "MOVIE_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);
    }

    @Override
    public void onTheaterSelected(String title) {

    }


}
