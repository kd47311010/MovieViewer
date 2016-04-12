package com.namhyun.movieviewerassist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailInfo {
    @SerializedName("movieInfoResult")
    private Result result;

    public MovieInfo getInfo() {
        return result.getInfo();
    }

    public String getSource() {
        return result.getSource();
    }

    public class Result {
        @SerializedName("movieInfo")
        private MovieInfo info;
        private String source;

        public MovieInfo getInfo() {
            return info;
        }

        public String getSource() {
            return source;
        }
    }

    public class MovieInfo {
        private String movieNm;
        private String movieNmEn;
        private String movieNmOg;
        private String showTm;
        private String prdtYear;
        private String openDt;
        private String prdtStatNm;
        private String typeNm;
        private List<Nation> nations;
        private List<Genre> genres;
        private List<Audit> audits;
        private List<Actor> actors;
        private List<Director> directors;

        public String getMovieNm() {
            return movieNm;
        }

        public String getMovieNmEn() {
            return movieNmEn;
        }

        public String getMovieNmOg() {
            return movieNmOg;
        }

        public String getShowTm() {
            return showTm;
        }

        public String getPrdtYear() {
            return prdtYear;
        }

        public String getOpenDt() {
            return openDt;
        }

        public String getPrdtStatNm() {
            return prdtStatNm;
        }

        public String getTypeNm() {
            return typeNm;
        }

        public List<Nation> getNations() {
            return nations;
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public List<Audit> getAudits() {
            return audits;
        }

        public List<Actor> getActors() {
            return actors;
        }

        public List<Director> getDirectors() {
            return directors;
        }
    }

    public class Nation {
        private String nationNm;

        public String getName() {
            return nationNm;
        }
    }

    public class Genre {
        private String genreNm;

        public String getName() {
            return genreNm;
        }
    }

    public class Audit {
        private String watchGradeNm;

        public String getName() {
            return watchGradeNm;
        }
    }

    public class Director {
        private String peopleNm;
        private String peopleNmEn;

        public String getPeopleNm() {
            return peopleNm;
        }

        public String getPeopleNmEn() {
            return peopleNmEn;
        }
    }

    public class Actor {
        private String peopleNm;
        private String peopleNmEn;
        private String cast;
        private String castEn;

        public String getPeopleNm() {
            return peopleNm;
        }

        public String getPeopleNmEn() {
            return peopleNmEn;
        }

        public String getCast() {
            return cast;
        }

        public String getCastEn() {
            return castEn;
        }
    }
}
