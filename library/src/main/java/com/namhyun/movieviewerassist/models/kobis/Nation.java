package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nation {

    @SerializedName("nationNm")
    @Expose
    private String nationNm;

    /**
     * @return The nationNm
     */
    public String getNationNm() {
        return nationNm;
    }

    /**
     * @param nationNm The nationNm
     */
    public void setNationNm(String nationNm) {
        this.nationNm = nationNm;
    }

}
