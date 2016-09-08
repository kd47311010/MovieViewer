package com.namhyun.movieviewerassist.services;

import com.namhyun.movieviewerassist.models.kobis.DailyBoxOffice;
import com.namhyun.movieviewerassist.models.kobis.MovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface KobisApiService {
    String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/";

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Observable<DailyBoxOffice> getDailyBoxOfficeObservable(@Query("key") String key, @Query("targetDt") String searchDate);

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Call<DailyBoxOffice> getDailyBoxOffice(@Query("key") String key, @Query("targetDt") String searchDate);

    @GET("movie/searchMovieInfo.json")
    Observable<MovieInfo> getMovieInfoObservable(@Query("key") String key, @Query("movieCd") String movieCode);

    @GET("movie/searchMovieInfo.json")
    Call<MovieInfo> getMovieInfo(@Query("key") String key, @Query("movieCd") String movieCode);
}
