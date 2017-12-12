package com.sandeepshabd.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * The first activity that gets launched on launch of application.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
