package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;

import com.sandeepshabd.popularmovies.activity.IMovieListingInvoker;
import com.sandeepshabd.popularmovies.model.MovieResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Test for MovieLisitingPresenter
 */

@RunWith(MockitoJUnitRunner.class)
public class MovieLisitingPresenterTest {

    @Mock
    IMovieListingInvoker movieListingInvoker;

    @Mock
    Context context;

    private String VALID_DATA ="{\n" +
            "\t\"page\": 1,\n" +
            "\t\"total_results\": 19764,\n" +
            "\t\"total_pages\": 989,\n" +
            "\t\"results\": [{\n" +
            "\t\t\"vote_count\": 4385,\n" +
            "\t\t\"id\": 346364,\n" +
            "\t\t\"video\": false,\n" +
            "\t\t\"vote_average\": 7.2,\n" +
            "\t\t\"title\": \"It\",\n" +
            "\t\t\"popularity\": 995.18693,\n" +
            "\t\t\"poster_path\": \"\\/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg\",\n" +
            "\t\t\"original_language\": \"en\",\n" +
            "\t\t\"original_title\": \"It\",\n" +
            "\t\t\"genre_ids\": [18, 14, 27, 53],\n" +
            "\t\t\"backdrop_path\": \"\\/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg\",\n" +
            "\t\t\"adult\": false,\n" +
            "\t\t\"overview\": \"In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.\",\n" +
            "\t\t\"release_date\": \"2017-09-05\"\n" +
            "\t}]\n" +
            "}";

    @Test
    public void testParsingOfData_NullData() {
        when(movieListingInvoker.getActivityContext()).thenReturn(context);
        MovieListingPresenter movieListingPresenter =
                new MovieListingPresenter(movieListingInvoker);
        MovieResponse movieResponse = movieListingPresenter.parseMovieData(null);
        assertThat(movieResponse.movieDetailsList.size(), is(0));
    }

    @Test
    public void testParsingOfData_EmptyData() {
        when(movieListingInvoker.getActivityContext()).thenReturn(context);
        MovieListingPresenter movieListingPresenter =
                new MovieListingPresenter(movieListingInvoker);
        MovieResponse movieResponse = movieListingPresenter.parseMovieData("");
        assertThat(movieResponse.movieDetailsList.size(), is(0));
    }

    @Test
    public void testParsingOfData_EmptyJSONString() {
        when(movieListingInvoker.getActivityContext()).thenReturn(context);
        MovieListingPresenter movieListingPresenter =
                new MovieListingPresenter(movieListingInvoker);
        MovieResponse movieResponse = movieListingPresenter.parseMovieData("{}");
        assertThat(movieResponse.movieDetailsList.size(), is(0));
    }

    @Test
    public void testParsingOfData_WrongJSONString() {
        when(movieListingInvoker.getActivityContext()).thenReturn(context);
        MovieListingPresenter movieListingPresenter =
                new MovieListingPresenter(movieListingInvoker);
        MovieResponse movieResponse = movieListingPresenter.parseMovieData(VALID_DATA);
        assertThat(movieResponse.movieDetailsList.size(), is(1));
    }
}
