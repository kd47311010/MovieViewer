package com.namhyun.movieviewerassist.services;

import com.namhyun.movieviewerassist.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieApiService {
    String BASE_URL = "http://api.themoviedb.org/3";

    @GET("search/movie")
    Call<MovieResult> searchMovie(@Query("api_key") String key, @Query("query") String query);

    // @GET("movie/{id}/images")
    // Call<String> searchMovieImage(@Query("api_key") String key, @Path("id") String movieId);

    // @GET("movie/{id}/images")
    // Call<String> searchMovieImage(@Query("api_key") String key, @Path("id") String movieId, @Query("language") String language);
}