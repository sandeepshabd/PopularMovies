package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.presenter.SplashPresenter;

/**
 * The first activity that gets launched on launch of application.
 */

public class SplashActivity extends BaseActivity {

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter = new SplashPresenter(this);
        splashPresenter.startFetchingMovieData();
    }
}
