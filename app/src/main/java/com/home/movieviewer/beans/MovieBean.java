package com.home.movieviewer.beans;

import com.namhyun.movieviewerassist.models.kobis.DailyBoxOfficeList;
import com.namhyun.movieviewerassist.models.tmdb.Movie;

/**
 * Created by namhyun on 2015-03-11.
 */
public class MovieBean {
    /**
        Kobis BoxOfficeList Object.
     */
    private final DailyBoxOfficeList boxOfficeList;
    /**
        The Movie Api MovieInfo Object.
     */
    private final Movie tmdbMovieInfo;

    public MovieBean(DailyBoxOfficeList boxOfficeList, Movie tmdbMovieInfo) {
        this.boxOfficeList = boxOfficeList;
        this.tmdbMovieInfo = tmdbMovieInfo;
    }

    public DailyBoxOfficeList getBoxOfficeList() {
        return boxOfficeList;
    }

    public Movie getTmdbMovieInfo() {
        return tmdbMovieInfo;
    }
}
