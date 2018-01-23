package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.ITheaterView;
import com.sandeepshabd.popularmovies.model.MovieData;
import com.sandeepshabd.popularmovies.model.theater.TheaterAndTimings;

import java.util.ArrayList;

/**
 * Created by sandeepshabd on 1/1/18.
 */

public class TheaterListingAdapter extends RecyclerView.Adapter<TheaterViewHolder> {

    ITheaterView theaterView;
    ArrayList<TheaterAndTimings> theaterTimingList;
    MovieData movieDataList;

    public TheaterListingAdapter(ITheaterView theaterView, ArrayList<TheaterAndTimings> theaterTimingList, MovieData movieData) {
        this.theaterView = theaterView;
        this.theaterTimingList = theaterTimingList;
        this.movieDataList = movieData;
    }

    @Override
    public TheaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View theaterCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.theater_card_view, parent, false);
        return new TheaterViewHolder(theaterCardView);
    }

    @Override
    public void onBindViewHolder(TheaterViewHolder holder, int position) {
        holder.theaterTitle.setText(movieDataList.getShowtimes().get(position).getTheatre().getName());
//        String date = movieDataList.getShowtimes().get(position).getDateTime().indexOf("T");
        holder.movieDate.setText(movieDataList.getShowtimes().get(position).getDateTime());
    }

    @Override
    public int getItemCount() {
        return theaterTimingList.size();
    }

    public void addDataToList(ArrayList<TheaterAndTimings> theaterTimingList) {
        this.theaterTimingList.addAll(theaterTimingList);
        notifyDataSetChanged();
    }
}
