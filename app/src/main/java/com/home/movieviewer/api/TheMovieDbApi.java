package com.home.movieviewer.api;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by namhyun on 2015-02-11.
 */
public class TheMovieDbApi implements ApiImpl {
    public static final int TYPE_SEARCH_MOVIE = 100;
    public static final int TYPE_MOVIE_IMAGE = 101;

    private final String BASE_URL = "http://api.themoviedb.org/3";
    private final String QUERY_SEARCH = "search";
    private final String QUERY_MOVIE = "movie";
    private final String QUERY_IMAGES = "images";

    @Deprecated
    private final String API_KEY = "848790748cc5407875ba6ae106a18f24"; // TEST KEY!
    private final String PARAM_KEY = "api_key";
    private final String PARAM_QUERY = "query";
    private final String PARAM_LANGUAGE = "language";

    private int mType = 0;
    private String mParamQuery = null;
    private String mParamLanguage = null;
    private String mParamId = null;

    public TheMovieDbApi(int mType) {
        this.mType = mType;
    }

    @Override
    public Uri getUri() {
        Uri.Builder builder = Uri.parse(BASE_URL).buildUpon();
        if (mType == TYPE_MOVIE_IMAGE) {
            if (mParamId != null && mParamLanguage != null) {
                builder.appendPath(QUERY_MOVIE)
                        .appendPath(mParamId).appendPath(QUERY_IMAGES)
                        .appendQueryParameter(PARAM_LANGUAGE, mParamLanguage);
            } else {
                return null;
            }
        } else if (mType == TYPE_SEARCH_MOVIE) {
            if (mParamQuery != null) {
                builder.appendPath(QUERY_SEARCH).appendPath(QUERY_MOVIE)
                        .appendQueryParameter(PARAM_QUERY, mParamQuery);
            } else {
                return null;
            }
        } else {
            return null;
        }
        return builder.appendQueryParameter(PARAM_KEY, API_KEY).build();
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public void setParams(String... params) {
        if (mType == TYPE_MOVIE_IMAGE) {
            mParamId = params[0];
            mParamLanguage = params[1];
        } else if (mType == TYPE_SEARCH_MOVIE) {
            mParamQuery = params[0];
        }
    }

    public static String getMovieIdFromJson(String jsonStr) {
        final String KEY_RESULTS = "results";
        final String KEY_ID = "id";

        String movieId = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray resultsArray = jsonObject.getJSONArray(KEY_RESULTS);
            movieId = resultsArray.getJSONObject(0).getString(KEY_ID);
            if (movieId == null) {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return movieId;
    }

    public static String getMoviePosterUrlFromJson(String jsonStr) {
        final String KEY_RESULTS = "results";
        final String KEY_POSTER_PATH = "poster_path";

        String posterPath = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray resultsArray = jsonObject.getJSONArray(KEY_RESULTS);
            posterPath = resultsArray.getJSONObject(0).getString(KEY_POSTER_PATH);
            if (posterPath == null) {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return posterPath;
    }

    public static String getMovieImageUrlFromJson(String jsonStr, int index) throws JSONException {
        final String KEY_POSTERS = "posters";
        final String KEY_FILE_PATH = "file_path";

        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONArray posterArray = jsonObject.getJSONArray(KEY_POSTERS);
        return posterArray.getJSONObject(index).getString(KEY_FILE_PATH);
    }

    public static String createImageUrl(String filePath) {
        final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
        final String FILE_SIZE_ORIGINAL = "original";

        Uri.Builder builder = Uri.parse(IMAGE_BASE_URL).buildUpon()
                .appendPath(FILE_SIZE_ORIGINAL).appendPath(filePath.substring(1, filePath.length()));
        return builder.build().toString();
    }
}
