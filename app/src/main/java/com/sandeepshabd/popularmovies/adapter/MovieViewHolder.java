package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

/**
 * View Holder for Recycler View.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder{

    CardView cardView;
    ImageView moviePoster;
    TextView movieTitle;
    TextView movieRating;
    TextView movieReleaseDate;

    public MovieViewHolder(View itemView) {
        super(itemView);

        cardView = (CardView)itemView.findViewById(R.id.movieCardViewID);
        moviePoster = (ImageView)itemView.findViewById(R.id.moviePoster);
        movieTitle = (TextView)itemView.findViewById(R.id.movieTitle);
        movieRating = (TextView)itemView.findViewById(R.id.movieRating);
        movieReleaseDate = (TextView)itemView.findViewById(R.id.releaseDate);

    }
}
