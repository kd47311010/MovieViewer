package com.namhyun.movieviewerassist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {
    private List<Movie> results;

    public List<Movie> get() {
        return results;
    }

    public class Movie {
        @SerializedName("adult")
        private boolean adult;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("genre_ids")
        private List<Integer> genreIds;
        @SerializedName("id")
        private Integer id;
        @SerializedName("original_language")
        private String originalLanguage;
        @SerializedName("original_title")
        private String originalTitle;
        @SerializedName("overview")
        private String overview;
        @SerializedName("release_date")
        private String releaseDate;
        @SerializedName("poster_path")
        private String posterPath;
        @SerializedName("popularity")
        private Float popularity;
        @SerializedName("title")
        private String title;
        @SerializedName("video")
        private boolean video;
        @SerializedName("vote_average")
        private Float voteAverage;
        @SerializedName("vote_count")
        private Integer voteCount;

        public boolean isAdult() {
            return adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public Integer getId() {
            return id;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public String getOverview() {
            return overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public Float getPopularity() {
            return popularity;
        }

        public String getTitle() {
            return title;
        }

        public boolean isVideo() {
            return video;
        }

        public Float getVoteAverage() {
            return voteAverage;
        }

        public Integer getVoteCount() {
            return voteCount;
        }
    }
}
