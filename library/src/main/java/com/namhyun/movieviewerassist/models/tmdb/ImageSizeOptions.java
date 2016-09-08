package com.namhyun.movieviewerassist.models.tmdb;

public class ImageSizeOptions {
    private ImageSizeOptions() {
        // no-op.
        throw new UnsupportedOperationException();
    }

    public enum Backdrop {
        WIDTH_300("w300"),
        WIDTH_780("w780"),
        WIDTH_1280("w1280"),
        ORIGINAL("original");

        private final String value;

        Backdrop(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Logo {
        WIDTH_45("w45"),
        WIDTH_92("w92"),
        WIDTH_154("w154"),
        WIDTH_185("w185"),
        WIDTH_300("w300"),
        WIDTH_500("w500"),
        ORIGINAL("original");

        private final String value;

        Logo(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Poster {
        WIDTH_92("w92"),
        WIDTH_154("w154"),
        WIDTH_185("w185"),
        WIDTH_342("w342"),
        WIDTH_500("w500"),
        WIDTH_700("w780"),
        ORIGINAL("original");

        private final String value;

        Poster(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Profile {
        WIDTH_45("w45"),
        WIDTH_185("w185"),
        HEIGHT_632("h632"),
        ORIGINAL("original");

        private final String value;

        Profile(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Still {
        WIDTH_92("w92"),
        WIDTH_185("w185"),
        WIDTH_300("w300"),
        ORIGINAL("original");

        private final String value;

        Still(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}