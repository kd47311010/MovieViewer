package com.home.movieviewer.beans;

import java.util.List;

/**
 * Created by namhyun on 2015-03-11.
 */
public class MovieBean {
    private String audiInten;
    private String rankOldAndNew;
    private String thumbnailUrl;
    private String rankInten;
    private String rank;
    private String movieNm;
    private String openDt;
    private String audiCnt;
    private String audiAcc;
    private DetailBean detail;

    public String getAudiInten() {
        return audiInten;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getRankInten() {
        return rankInten;
    }

    public DetailBean getDetail() {
        return detail;
    }

    public String getRank() {
        return rank;
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

    public String getAudiAcc() {
        return audiAcc;
    }

    public class DetailBean {
        private String watchGradeNm;
        private String showTm;
        private List<String> genreNm;

        public String getWatchGradeNm() {
            return watchGradeNm;
        }

        public String getShowTm() {
            return showTm;
        }

        public List<String> getGenreNm() {
            return genreNm;
        }
    }
}
