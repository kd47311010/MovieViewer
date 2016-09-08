package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("genreNm")
    @Expose
    private String genreNm;

    /**
     * @return The genreNm
     */
    public String getGenreNm() {
        return genreNm;
    }

    /**
     * @param genreNm The genreNm
     */
    public void setGenreNm(String genreNm) {
        this.genreNm = genreNm;
    }

}
