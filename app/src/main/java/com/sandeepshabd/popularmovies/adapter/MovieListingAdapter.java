package com.sandeepshabd.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.sandeepshabd.popularmovies.R;
import com.sandeepshabd.popularmovies.activity.IMovieDataFetcher;
import com.sandeepshabd.popularmovies.backOffice.BackOfficeDetails;
import com.sandeepshabd.popularmovies.model.MovieDetails;

import java.util.ArrayList;

import hugo.weaving.DebugLog;

/**
 * This is adapter to the Movie listing recyclerView.
 */

public class MovieListingAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private ArrayList<MovieDetails> movieDetails;
    private RequestManager glide;
    private IMovieDataFetcher movieDataFetcher;

    public MovieListingAdapter(RequestManager glide, ArrayList<MovieDetails> movieDetails,
                               IMovieDataFetcher movieDataFetcher) {
        this.movieDetails = movieDetails;
        this.glide = glide;
        this.movieDataFetcher = movieDataFetcher;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @DebugLog
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_view, parent, false);
        return new MovieViewHolder(movieCardView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int position) {
        String url = BackOfficeDetails.getImagePathURL(movieDetails.get(position).posterPath);
        loadImage(movieViewHolder.moviePoster, url);
        movieViewHolder.movieTitle.setText(movieDetails.get(position).title);
        movieViewHolder.movieRating.setRating(movieDetails.get(position).getPopularity() / 200);
        movieViewHolder.movieReleaseDate.setText(movieDetails.get(position).getReleaseDate());

        if (position + 1 == getItemCount()) {
            movieDataFetcher.fetchMoreData();
        }

        callTheaterListing(movieViewHolder, movieDetails.get(position).title, url);
    }

    private void callTheaterListing(final MovieViewHolder movieViewHolder, final String movieTitle, final String url) {
        movieViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieDataFetcher.onMovieSelected(movieTitle, url, movieViewHolder.moviePoster);
            }
        });
    }

    private void loadImage(ImageView view, String url) {
        try {
            glide.asBitmap()
                    .load(url)
                    .into(view);
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        return movieDetails.size();
    }

    public void addDataToList(ArrayList<MovieDetails> newMovieDetails) {
        movieDetails.addAll(newMovieDetails);
        notifyDataSetChanged();
    }
}
