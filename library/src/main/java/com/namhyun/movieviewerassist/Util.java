package com.namhyun.movieviewerassist;

import android.net.Uri;

public class Util {
    public static class TheMovieApiUtil {
        public static final String BASE_URL = "http://image.tmdb.org/t/p/";
        public static final String SECURE_BASE_URL = "https://image.tmdb.org/t/p/";

        private TheMovieApiUtil() {
            // no-op.
            throw new UnsupportedOperationException();
        }

        public static Uri getImageUrl(String path, String sizeOptions) {
            Uri uri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath(sizeOptions)
                .appendPath(path.substring(1, path.length()))
                .build();
            return uri;
        }
    }   
}