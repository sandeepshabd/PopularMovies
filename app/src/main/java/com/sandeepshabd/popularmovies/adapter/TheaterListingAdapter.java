package com.sandeepshabd.popularmovies.adapter;

import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.ITheaterView;
import com.sandeepshabd.popularmovies.activity.TheaterActivity;
import com.sandeepshabd.popularmovies.model.MovieData;
import com.sandeepshabd.popularmovies.model.theater.TheaterAndTimings;
import com.telenav.arp.service.navigation.LocationInfo;

import java.util.ArrayList;
import java.util.Locale;

import hugo.weaving.DebugLog;

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
    public void onBindViewHolder(TheaterViewHolder holder, final int position) {
        holder.theaterTitle.setText(movieDataList.getShowtimes().get(position).getTheatre().getName());
//        String date = movieDataList.getShowtimes().get(position).getDateTime().indexOf("T");
        holder.movieDate.setText(movieDataList.getShowtimes().get(position).getDateTime());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNavigation(movieDataList.getShowtimes().get(position).getTheatre().getName());
            }
        });
    }

    @DebugLog
    private void startNavigation(String name) {
        Intent intent = new Intent();
        intent.setAction(((TheaterActivity) theaterView).getString(R.string.ACTIVITY_TELENAV_SEARCH));

        Location destinationRequest = new Location("");
        destinationRequest.setLatitude(Double.parseDouble("42.328676"));
        destinationRequest.setLongitude(Double.parseDouble("-83.04012"));

        LocationInfo destinationRequestAddressInfo = new LocationInfo();
        destinationRequestAddressInfo.address = getAddressFromDestination(name);
        destinationRequest.setExtras(destinationRequestAddressInfo.toBundle());

//        intent.putExtra("onebox", business.getAddress());
//        intent.putExtra("label", business.getStation());
        intent.putExtra("destination", destinationRequest);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ((TheaterActivity) theaterView).startActivity(intent);
    }

    private Address getAddressFromDestination(String name) {
        Address newAddress = new Address(Locale.US);
        newAddress.setAddressLine(1, name);
//        if (!TextUtils.isEmpty(stationsItem.getLocation().getAddress1())) {
//            newAddress.setAddressLine(2, stationsItem.getLocation().getAddress2());
//        }
        newAddress.setLatitude(Double.parseDouble("42.328676"));
        newAddress.setLongitude(Double.parseDouble("-83.04012"));
        return newAddress;
    }

    @Override
    public int getItemCount() {
        return movieDataList.getShowtimes().size();
    }

    public void addDataToList(ArrayList<TheaterAndTimings> theaterTimingList) {
        this.theaterTimingList.addAll(theaterTimingList);
        notifyDataSetChanged();
    }
}
