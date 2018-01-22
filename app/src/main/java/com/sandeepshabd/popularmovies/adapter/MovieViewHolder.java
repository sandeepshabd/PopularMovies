package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sandeepshabd.popularmovies.R;

/**
 * View Holder for Recycler View.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder{

    CardView cardView;
    ImageView moviePoster;
    TextView movieTitle;
    RatingBar movieRating;
    TextView movieReleaseDate;

    public MovieViewHolder(View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.movieCardViewID);
        moviePoster = itemView.findViewById(R.id.moviePoster);
        movieTitle = itemView.findViewById(R.id.movieTitle);
        movieRating =itemView.findViewById(R.id.movieRating);
        movieReleaseDate = itemView.findViewById(R.id.releaseDate);

    }
}
