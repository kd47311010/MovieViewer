package com.home.movieviewer.beans;

import java.util.List;

/**
 * Created by namhyun on 2015-03-11.
 */
public class MovieBean {
    public String audiInten;
    public String rankOldAndNew;
    public String thumbnailUrl;
    public String rankInten;
    public String rank;
    public String movieNm;
    public String openDt;
    public String audiCnt;
    public String audiAcc;
    public DetailBean detail;

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
        public String watchGradeNm;
        public String showTm;
        public List<String> genreNm;

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
