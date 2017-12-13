package com.sandeepshabd.popularmovies.helper;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import hugo.weaving.DebugLog;

/**
 * This is a singleton class helper class that provides the Request Queue so that
 * the requests can be added.
 */

public class VolleyQueueHelper {
    private static final String TAG = VolleyQueueHelper.class.getSimpleName();
    private static VolleyQueueHelper volleyQueueHelper;
    private RequestQueue requestQueue;

    private VolleyQueueHelper() {
    }

    @DebugLog
    private VolleyQueueHelper(Context context) {
        requestQueue = getRequestQueue(context);
    }


    //provides a synchronized single instance of the class
    @DebugLog
    public static synchronized VolleyQueueHelper getInstance(Context context) {

        if (volleyQueueHelper == null) {
            volleyQueueHelper = new VolleyQueueHelper(context);
        }
        return volleyQueueHelper;
    }

    @DebugLog
    private RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    //requests get added in the queue
    @DebugLog
    public void addRequestToRequestQueue(Request request) {
        if (requestQueue != null) {
            requestQueue.add(request);
        } else {
            Log.i(TAG, "addRequestToRequestQueue:requestQueue is null ");
        }
    }

}
