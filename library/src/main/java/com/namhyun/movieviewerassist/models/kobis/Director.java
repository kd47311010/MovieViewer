package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Director {

    @SerializedName("peopleNm")
    @Expose
    private String peopleNm;
    @SerializedName("peopleNmEn")
    @Expose
    private String peopleNmEn;

    /**
     * @return The peopleNm
     */
    public String getPeopleNm() {
        return peopleNm;
    }

    /**
     * @param peopleNm The peopleNm
     */
    public void setPeopleNm(String peopleNm) {
        this.peopleNm = peopleNm;
    }

    /**
     * @return The peopleNmEn
     */
    public String getPeopleNmEn() {
        return peopleNmEn;
    }

    /**
     * @param peopleNmEn The peopleNmEn
     */
    public void setPeopleNmEn(String peopleNmEn) {
        this.peopleNmEn = peopleNmEn;
    }

}
