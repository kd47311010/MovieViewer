package com.home.movieviewer;

import android.net.Uri;

/**
 * Created by 88 on 2015-01-14.
 */
public class MovieApi {
    public static final int TYPE_COMMON_CODE = 100;
    public static final int TYPE_DAILY_BOX_OFFICE = 101;
    public static final int TYPE_MOVIE_DETAIL_INFO = 102;
    public static final int TYPE_MOVIE_LIST = 103;
    public static final int TYPE_MOVIE_IMAGE = 104;

    private static String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest, http://api.themoviedb.org/3/movie/id/images";
    private static String QUERY_CODE = "code";
    private static String QUERY_SEARCH_CODE_LIST = "searchCodeList";
    private static String QUERY_BOXOFFICE = "boxoffice";
    private static String QUERY_SEARCH_DAILY_BOXOFFICE_LIST = "searchDailyBoxOfficeList";
    private static String QUERY_MOVIE = "movie";
    private static String QUERY_SEARCH_MOVIE_INFO = "searchMovieInfo";
    private static String QUERY_SEARCH_MOVIE_LIST = "searchMovieList";
    private static String QUERY_MOVIE_IMAGE = "MovieImage";
    private static String QUERY_TYPE = ".json";

    private static String API_KEY = "7ffbb106d667ab3ddf34dc7ba8ff2c65, fde3da14391601d0df038f21e7837ccc";
    private static String PARAM_KEY = "key";

    public static Uri getUri(int type) {
        Uri.Builder builder = Uri.parse(BASE_URL).buildUpon();
        switch (type) {
            case TYPE_COMMON_CODE:
                builder.appendPath(QUERY_CODE)
                        .appendPath(QUERY_SEARCH_CODE_LIST + QUERY_TYPE);
                break;
            case TYPE_DAILY_BOX_OFFICE:
                builder.appendPath(QUERY_BOXOFFICE)
                        .appendPath(QUERY_SEARCH_DAILY_BOXOFFICE_LIST + QUERY_TYPE);
                break;
            case TYPE_MOVIE_DETAIL_INFO:
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(QUERY_SEARCH_MOVIE_INFO + QUERY_TYPE);
                break;
            case TYPE_MOVIE_LIST:
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(QUERY_SEARCH_MOVIE_LIST + QUERY_TYPE);
                break;
            case TYPE_MOVIE_IMAGE:
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(QUERY_MOVIE_IMAGE + QUERY_TYPE);
            default:
                return null;
        }
        return builder.appendQueryParameter(PARAM_KEY, API_KEY).build();
    }
}
