package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterViewHolder extends  RecyclerView.ViewHolder {

    CardView cardView;
    TextView theaterTitle;
    TextView movieTiming;

    public TheaterViewHolder(View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.theaterCardViewID);
        theaterTitle = itemView.findViewById(R.id.theaterTitle);
        movieTiming = itemView.findViewById(R.id.theaterTimings);
    }
}
