package com.namhyun.movieviewerassist.services;

import com.namhyun.movieviewerassist.models.BoxOfficeList;
import com.namhyun.movieviewerassist.models.DetailInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface KobisApiService {
    String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest";

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Observable<BoxOfficeList> searchDailyBoxOfficeList(@Query("key") String key, @Query("targetDt") String searchDate);

    @GET("movie/searchMovieInfo.json")
    Observable<DetailInfo> searchMovieInfo(@Query("key") String key, @Query("movieCd") String movieCode);
}
