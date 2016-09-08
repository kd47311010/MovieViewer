package com.namhyun.movieviewerassist.services;

import com.namhyun.movieviewerassist.models.tmdb.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TheMovieApiService {
    String BASE_URL = "http://api.themoviedb.org/3/";

    @GET("search/movie")
    Observable<Movie> searchMovieObservable(@Query("api_key") String key, @Query("query") String query);

    @GET("search/movie")
    Call<Movie> searchMovie(@Query("api_key") String key, @Query("query") String query);
}