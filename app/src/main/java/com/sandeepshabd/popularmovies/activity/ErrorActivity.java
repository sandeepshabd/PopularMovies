package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

import hugo.weaving.DebugLog;

/*
* This activity will show error screen.
* */
public class ErrorActivity extends BaseActivity {

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        Toolbar errorToolbar = findViewById(R.id.error_toolbar);
        setSupportActionBar(errorToolbar);
        setTitle(R.string.error_msg_title);
    }

    @DebugLog
    public void closeScreen(View view) {
        finish();
    }
}
