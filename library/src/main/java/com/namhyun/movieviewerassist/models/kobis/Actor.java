package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor {

    @SerializedName("peopleNm")
    @Expose
    private String peopleNm;
    @SerializedName("peopleNmEn")
    @Expose
    private String peopleNmEn;
    @SerializedName("cast")
    @Expose
    private String cast;
    @SerializedName("castEn")
    @Expose
    private String castEn;

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

    /**
     * @return The cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * @param cast The cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     * @return The castEn
     */
    public String getCastEn() {
        return castEn;
    }

    /**
     * @param castEn The castEn
     */
    public void setCastEn(String castEn) {
        this.castEn = castEn;
    }

}
