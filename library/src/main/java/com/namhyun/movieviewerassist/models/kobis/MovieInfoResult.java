package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieInfoResult {

    @SerializedName("movieInfo")
    @Expose
    private MovieInfo_ movieInfo;
    @SerializedName("source")
    @Expose
    private String source;

    /**
     * @return The movieInfo
     */
    public MovieInfo_ getMovieInfo() {
        return movieInfo;
    }

    /**
     * @param movieInfo The movieInfo
     */
    public void setMovieInfo(MovieInfo_ movieInfo) {
        this.movieInfo = movieInfo;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(String source) {
        this.source = source;
    }

}
