package com.sandeepshabd.popularmovies.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

/*
* This activity will show error screen.
* */
public class ErrorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        TextView errorMessage = findViewById(R.id.textView2);
        errorMessage.setText("An error has occurred while retrieving the data. ");
    }
}
