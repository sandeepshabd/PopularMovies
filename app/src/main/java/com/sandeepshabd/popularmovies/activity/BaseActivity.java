package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Common base activity.
 */

public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         hideNavigationBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }


    private void hideNavigationBar(){
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    }
}
