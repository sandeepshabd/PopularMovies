package com.sandeepshabd.popularmovies.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.sandeepshabd.popularmovies.R;

/**
 * The class helps in creating spinner for loading.
 */

public class SpinnerDialog  extends Dialog {

    public SpinnerDialog(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.spinner);
    }


}
