package com.home.movieviewer;

import android.net.Uri;

/**
 * Created by 88 on 2015-01-14.
 */
public class MovieDetailInfo {
    private static String BASE_URL
            = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json";

    public static String getUrl() {
        return Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(Config.PARAM_KEY, Config.API_KEY)
                .build().toString();
    }
}
