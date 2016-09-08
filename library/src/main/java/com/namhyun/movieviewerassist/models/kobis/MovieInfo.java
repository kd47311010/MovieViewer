package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieInfo {

    @SerializedName("movieInfoResult")
    @Expose
    private MovieInfoResult movieInfoResult;

    /**
     * @return The movieInfoResult
     */
    public MovieInfoResult getMovieInfoResult() {
        return movieInfoResult;
    }

    /**
     * @param movieInfoResult The movieInfoResult
     */
    public void setMovieInfoResult(MovieInfoResult movieInfoResult) {
        this.movieInfoResult = movieInfoResult;
    }

}
