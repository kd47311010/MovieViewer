package com.home.movieviewer.api;

import android.net.Uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by namhyun on 2015-03-06.
 */
@Deprecated
public class DaumMovieApi implements ApiImpl {
    private final String BASE_URL = "https://apis.daum.net/contents/movie";

    private final String API_KEY = "7e91ee405d32079c5e86101754dea58f";
    private final String PARAM_KEY = "apikey";
    private final String PARAM_QUERY = "q";
    private final String PARAM_OUTPUT = "output";

    private final String OUTPUT_TYPE = "json";

    private String mQuery = null;

    @Override
    public Uri getUri() {
        try {
            mQuery = URLEncoder.encode(mQuery, "EUC-KR");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Uri.Builder builder = Uri.parse(BASE_URL).buildUpon();
        builder.appendQueryParameter(PARAM_KEY, API_KEY)
                .appendQueryParameter(PARAM_QUERY, mQuery)
                .appendQueryParameter(PARAM_OUTPUT, OUTPUT_TYPE);
        return builder.build();
    }

    public String createQueryUrl() {
        String result = null;
//            + "&" + PARAM_QUERY + "=" + mQuery
//            mQuery = URLEncoder.encode(mQuery, "EUC-KR");
        result = getUri().toString();
        return result;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void setParams(String... params) {
        mQuery = params[0];
    }
}
