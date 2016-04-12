package com.namhyun.movieviewerassist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BoxOfficeList {
    @SerializedName("boxOfficeResult")
    private Result result;

    public List<BoxOfficeMovie> getBoxOfficeList() {
        return result.getList();
    }

    public class Result {
        @SerializedName("dailyBoxOfficeList")
        private List<BoxOfficeMovie> list;

        public List<BoxOfficeMovie> getList() {
            return list;
        }
    }

    public class BoxOfficeMovie {
        private String rank;
        private String rankInten;
        private String rankOldAndNew;
        private String movieNm;
        private String openDt;
        private String audiCnt;
        private String audiInten;
        private String audiChange;
        private String audiAcc;

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

        public String getAudiInten() {
            return audiInten;
        }

        public String getAudiChange() {
            return audiChange;
        }

        public String getAudiAcc() {
            return audiAcc;
        }
    }
}
