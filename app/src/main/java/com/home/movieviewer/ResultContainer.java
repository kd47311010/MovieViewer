package com.home.movieviewer;

/**
 * Created by P400 on 2015-02-05.
 */
public class ResultContainer {
    private String rnum;
    private String rank;
    private String rankInten;
    private String rankOldAndNew;
    private String movieNm;
    private String openDt;
    private String audiCnt;

    public ResultContainer(String rnum, String rank, String rankInten, String rankOldAndNew, String movieNm, String openDt, String audiCnt) {
        this.rnum = rnum;
        this.rank = rank;
        this.rankInten = rankInten;
        this.rankOldAndNew = rankOldAndNew;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiCnt = audiCnt;
    }

    public String getRnum() {
        return rnum;
    }

    public String getRank() {
        return rank;
    }

    public String getRankInten() {
        return rankInten;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public String getAudiCnt() {
        return audiCnt;
    }


}