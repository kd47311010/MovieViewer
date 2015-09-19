package com.home.movieviewer;

/**
 * Default configuration data
 *
 * @author namhyun
 */
public class Config {
    private Config() {
        // no-op.
    }

    public class ThumbnailImageService {
        public static final String BASE_URL = "http://image.tmdb.org/t/p/";
        public static final String FILE_SIZE_ORIGINAL = "original";

        private ThumbnailImageService() {
            // no-op.
        }
    }
}
