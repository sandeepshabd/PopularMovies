package com.sandeepshabd.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar aboutToolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        setTitle(R.string.about_title);
        aboutToolbar.setNavigationIcon(R.mipmap.ic_navigate_before_black_24dp);
        aboutToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView textView = findViewById(R.id.aboutText);
        textView.setText(getText(R.string.ui_open_source_license_info));
    }
}
