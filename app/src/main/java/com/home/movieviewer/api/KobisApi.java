package com.home.movieviewer.api;

import android.net.Uri;

/**
 * Created by namhyun on 2015-02-11.
 *
 * Unused class, will be deleted
 */
@Deprecated
public class KobisApi implements ApiImpl {
    public static final int TYPE_COMMON_CODE = 100;
    public static final int TYPE_DAILY_BOX_OFFICE = 101;
    public static final int TYPE_MOVIE_DETAIL_INFO = 102;
    public static final int TYPE_MOVIE_LIST = 103;

    private final String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest";
    private final String QUERY_CODE = "code";
    private final String QUERY_SEARCH_CODE_LIST = "searchCodeList";
    private final String QUERY_BOXOFFICE = "boxoffice";
    private final String QUERY_SEARCH_DAILY_BOXOFFICE_LIST = "searchDailyBoxOfficeList";
    private final String QUERY_MOVIE = "movie";
    private final String QUERY_SEARCH_MOVIE_INFO = "searchMovieInfo";
    private final String QUERY_SEARCH_MOVIE_LIST = "searchMovieList";
    private final String QUERY_TYPE = ".json";

    private final String API_KEY = "7ffbb106d667ab3ddf34dc7ba8ff2c65";
    private final String PARAM_KEY = "key";
    private final String PARAM_TARGET_DT = "targetDt";

    private int mType;
    private String mParamTargetDt = null;

    public KobisApi(int type) {
        this.mType = type;
    }

    @Override
    public Uri getUri() {
        Uri.Builder builder = Uri.parse(BASE_URL).buildUpon();
        switch (getType()) {
            case TYPE_COMMON_CODE:
                builder.appendPath(QUERY_CODE)
                        .appendPath(QUERY_SEARCH_CODE_LIST + QUERY_TYPE);
                break;
            case TYPE_DAILY_BOX_OFFICE:
                if(mParamTargetDt != null) {
                    builder.appendPath(QUERY_BOXOFFICE)
                            .appendPath(QUERY_SEARCH_DAILY_BOXOFFICE_LIST + QUERY_TYPE)
                            .appendQueryParameter(PARAM_TARGET_DT, mParamTargetDt);
                } else {
                    return null;
                }
                break;
            case TYPE_MOVIE_DETAIL_INFO:
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(QUERY_SEARCH_MOVIE_INFO + QUERY_TYPE);
                break;
            case TYPE_MOVIE_LIST:
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(QUERY_SEARCH_MOVIE_LIST + QUERY_TYPE);
                break;
            default:
                return null;
        }
        return builder.appendQueryParameter(PARAM_KEY, API_KEY).build();
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public void setParams(String... params) {
        mParamTargetDt = params[0];
    }
}
