package com.sandeepshabd.popularmovies.helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import hugo.weaving.DebugLog;

/**
 * The class helps in making various BO calls.
 */

public class VolleyRequestHelper {

    Context context;

    @DebugLog
    public void makeVolleyGetRequest(Context context, String url, IVolleyReponseConsumer volleyReponseConsumer) {
        this.context = context;

        MovieResponse movieResponse = new MovieResponse(volleyReponseConsumer);
        MovieErrorListener movieErrorListener = new MovieErrorListener(volleyReponseConsumer);
        StringRequest movieStringRequest = new StringRequest(Request.Method.GET,
                url, movieResponse, movieErrorListener);
        VolleyQueueHelper volleyQueueHelper= VolleyQueueHelper.getInstance(context);
        volleyQueueHelper.addRequestToRequestQueue(movieStringRequest);

    }

    private class MovieErrorListener implements Response.ErrorListener {
        IVolleyReponseConsumer volleyReponseConsumer;

        public MovieErrorListener(IVolleyReponseConsumer volleyReponseConsumer) {
            this.volleyReponseConsumer = volleyReponseConsumer;
        }

        @DebugLog
        @Override
        public void onErrorResponse(VolleyError error) {
            volleyReponseConsumer.onErrorReponse(error);
        }
    }


    private class MovieResponse implements Response.Listener<String> {
        IVolleyReponseConsumer volleyReponseConsumer;

        public MovieResponse(IVolleyReponseConsumer volleyReponseConsumer) {
            this.volleyReponseConsumer = volleyReponseConsumer;
        }

        @DebugLog
        @Override
        public void onResponse(String response) {
            volleyReponseConsumer.onSuccessResponse(response);
        }
    }

    public interface IVolleyReponseConsumer {
        void onSuccessResponse(String response);
        void onErrorReponse(VolleyError volleyError);
    }


}
