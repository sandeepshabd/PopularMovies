package com.sandeepshabd.popularmovies.model.theater;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class Showtimes {

    private static final String TAG = Showtimes.class.getSimpleName();
    private static final SimpleDateFormat dateFormatUS = new SimpleDateFormat("E, y-MM-dd 'at' hh:mm a z", Locale.getDefault());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);

    @SerializedName("theatre")
    public Theater theater;

    @SerializedName("dateTime")
    public String dateTime;

    public String getShowTime() {
        try {
            Date date = dateFormat.parse(dateTime);
            dateTime = dateFormatUS.format(date);
        } catch (Exception e) {
            Log.e(TAG, "getShowTime: date exception");
        }
        return dateTime;
    }
}
