package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.ITheaterView;
import com.sandeepshabd.popularmovies.model.TheaterAndTimings;

import java.util.ArrayList;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterListingAdapter extends RecyclerView.Adapter<TheaterViewHolder> {

    ITheaterView theaterView;
    ArrayList<TheaterAndTimings> theaterTimingList;

    public TheaterListingAdapter(ITheaterView theaterView, ArrayList<TheaterAndTimings> theaterTimingList){
        this.theaterView = theaterView;
        this.theaterTimingList = theaterTimingList;
    }

    @Override
    public TheaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View theaterCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.theater_card_view, parent, false);
        return new TheaterViewHolder(theaterCardView);
    }

    @Override
    public void onBindViewHolder(TheaterViewHolder holder, int position) {
        holder.theaterTitle.setText(theaterTimingList.get(position).movieTheater);
        holder.movieTiming.setText(theaterTimingList.get(position).movieTiming);
    }

    @Override
    public int getItemCount() {
        return theaterTimingList.size();
    }
}
