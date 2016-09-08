package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BoxOfficeResult {

    @SerializedName("boxofficeType")
    @Expose
    private String boxofficeType;
    @SerializedName("showRange")
    @Expose
    private String showRange;
    @SerializedName("dailyBoxOfficeList")
    @Expose
    private List<DailyBoxOfficeList> dailyBoxOfficeList = new ArrayList<DailyBoxOfficeList>();

    /**
     * @return The boxofficeType
     */
    public String getBoxofficeType() {
        return boxofficeType;
    }

    /**
     * @param boxofficeType The boxofficeType
     */
    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    /**
     * @return The showRange
     */
    public String getShowRange() {
        return showRange;
    }

    /**
     * @param showRange The showRange
     */
    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    /**
     * @return The dailyBoxOfficeList
     */
    public List<DailyBoxOfficeList> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    /**
     * @param dailyBoxOfficeList The dailyBoxOfficeList
     */
    public void setDailyBoxOfficeList(List<DailyBoxOfficeList> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

}
