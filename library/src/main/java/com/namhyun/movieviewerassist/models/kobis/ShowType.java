package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowType {

    @SerializedName("showTypeGroupNm")
    @Expose
    private String showTypeGroupNm;
    @SerializedName("showTypeNm")
    @Expose
    private String showTypeNm;

    /**
     * @return The showTypeGroupNm
     */
    public String getShowTypeGroupNm() {
        return showTypeGroupNm;
    }

    /**
     * @param showTypeGroupNm The showTypeGroupNm
     */
    public void setShowTypeGroupNm(String showTypeGroupNm) {
        this.showTypeGroupNm = showTypeGroupNm;
    }

    /**
     * @return The showTypeNm
     */
    public String getShowTypeNm() {
        return showTypeNm;
    }

    /**
     * @param showTypeNm The showTypeNm
     */
    public void setShowTypeNm(String showTypeNm) {
        this.showTypeNm = showTypeNm;
    }

}
