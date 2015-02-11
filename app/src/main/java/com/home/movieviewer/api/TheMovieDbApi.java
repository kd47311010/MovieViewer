package com.home.movieviewer.api;

import android.net.Uri;

/**
 * Created by namhyun on 2015-02-11.
 *
 * @deprecated
 */
public class TheMovieDbApi implements ApiImpl {
    private final String BASE_URL = "http://api.themoviedb.org/3";
    private final String QUERY_MOVIE = "movie";
    private final String QUERY_IMAGES = "images";

    private final String API_KEY = "fde3da14391601d0df038f21e7837ccc";
    private final String PARAM_KEY = "api_key";

    private String mParamId = null;

    @Override
    public Uri getUri() {
        Uri.Builder builder = Uri.parse(BASE_URL).buildUpon();
        if (mParamId != null) {
            builder.appendPath(QUERY_MOVIE)
                    .appendPath(mParamId).appendPath(QUERY_IMAGES);
        } else {
            return null;
        }
        return builder.appendQueryParameter(PARAM_KEY, API_KEY).build();
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void setParams(String... params) {
        mParamId = params[0];
    }
}
