package com.sandeepshabd.popularmovies.activity;

import android.content.Context;

/**
 * The presenter knows about the activity using this interface.
 */

public interface ISplashInvoker {

    void finishTheActivity();
    Context getActivityContext();
}
