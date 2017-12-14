package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;

import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView textView = findViewById(R.id.aboutText);
        textView.setText(getText(R.string.ui_open_source_license_info));
    }
}
