package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyBoxOffice {

    @SerializedName("boxOfficeResult")
    @Expose
    private BoxOfficeResult boxOfficeResult;

    /**
     * @return The boxOfficeResult
     */
    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    /**
     * @param boxOfficeResult The boxOfficeResult
     */
    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

}
