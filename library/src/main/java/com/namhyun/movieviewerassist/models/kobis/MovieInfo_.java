package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieInfo_ {

    @SerializedName("movieCd")
    @Expose
    private String movieCd;
    @SerializedName("movieNm")
    @Expose
    private String movieNm;
    @SerializedName("movieNmEn")
    @Expose
    private String movieNmEn;
    @SerializedName("movieNmOg")
    @Expose
    private String movieNmOg;
    @SerializedName("showTm")
    @Expose
    private String showTm;
    @SerializedName("prdtYear")
    @Expose
    private String prdtYear;
    @SerializedName("openDt")
    @Expose
    private String openDt;
    @SerializedName("prdtStatNm")
    @Expose
    private String prdtStatNm;
    @SerializedName("typeNm")
    @Expose
    private String typeNm;
    @SerializedName("nations")
    @Expose
    private List<Nation> nations = new ArrayList<Nation>();
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<Genre>();
    @SerializedName("directors")
    @Expose
    private List<Director> directors = new ArrayList<Director>();
    @SerializedName("actors")
    @Expose
    private List<Actor> actors = new ArrayList<Actor>();
    @SerializedName("showTypes")
    @Expose
    private List<ShowType> showTypes = new ArrayList<ShowType>();
    @SerializedName("companys")
    @Expose
    private List<Company> companys = new ArrayList<Company>();
    @SerializedName("audits")
    @Expose
    private List<Audit> audits = new ArrayList<Audit>();
    @SerializedName("staffs")
    @Expose
    private List<Staff> staffs = new ArrayList<Staff>();

    /**
     * @return The movieCd
     */
    public String getMovieCd() {
        return movieCd;
    }

    /**
     * @param movieCd The movieCd
     */
    public void setMovieCd(String movieCd) {
        this.movieCd = movieCd;
    }

    /**
     * @return The movieNm
     */
    public String getMovieNm() {
        return movieNm;
    }

    /**
     * @param movieNm The movieNm
     */
    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    /**
     * @return The movieNmEn
     */
    public String getMovieNmEn() {
        return movieNmEn;
    }

    /**
     * @param movieNmEn The movieNmEn
     */
    public void setMovieNmEn(String movieNmEn) {
        this.movieNmEn = movieNmEn;
    }

    /**
     * @return The movieNmOg
     */
    public String getMovieNmOg() {
        return movieNmOg;
    }

    /**
     * @param movieNmOg The movieNmOg
     */
    public void setMovieNmOg(String movieNmOg) {
        this.movieNmOg = movieNmOg;
    }

    /**
     * @return The showTm
     */
    public String getShowTm() {
        return showTm;
    }

    /**
     * @param showTm The showTm
     */
    public void setShowTm(String showTm) {
        this.showTm = showTm;
    }

    /**
     * @return The prdtYear
     */
    public String getPrdtYear() {
        return prdtYear;
    }

    /**
     * @param prdtYear The prdtYear
     */
    public void setPrdtYear(String prdtYear) {
        this.prdtYear = prdtYear;
    }

    /**
     * @return The openDt
     */
    public String getOpenDt() {
        return openDt;
    }

    /**
     * @param openDt The openDt
     */
    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    /**
     * @return The prdtStatNm
     */
    public String getPrdtStatNm() {
        return prdtStatNm;
    }

    /**
     * @param prdtStatNm The prdtStatNm
     */
    public void setPrdtStatNm(String prdtStatNm) {
        this.prdtStatNm = prdtStatNm;
    }

    /**
     * @return The typeNm
     */
    public String getTypeNm() {
        return typeNm;
    }

    /**
     * @param typeNm The typeNm
     */
    public void setTypeNm(String typeNm) {
        this.typeNm = typeNm;
    }

    /**
     * @return The nations
     */
    public List<Nation> getNations() {
        return nations;
    }

    /**
     * @param nations The nations
     */
    public void setNations(List<Nation> nations) {
        this.nations = nations;
    }

    /**
     * @return The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * @param genres The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * @return The directors
     */
    public List<Director> getDirectors() {
        return directors;
    }

    /**
     * @param directors The directors
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    /**
     * @return The actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * @param actors The actors
     */
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * @return The showTypes
     */
    public List<ShowType> getShowTypes() {
        return showTypes;
    }

    /**
     * @param showTypes The showTypes
     */
    public void setShowTypes(List<ShowType> showTypes) {
        this.showTypes = showTypes;
    }

    /**
     * @return The companys
     */
    public List<Company> getCompanys() {
        return companys;
    }

    /**
     * @param companys The companys
     */
    public void setCompanys(List<Company> companys) {
        this.companys = companys;
    }

    /**
     * @return The audits
     */
    public List<Audit> getAudits() {
        return audits;
    }

    /**
     * @param audits The audits
     */
    public void setAudits(List<Audit> audits) {
        this.audits = audits;
    }

    /**
     * @return The staffs
     */
    public List<Staff> getStaffs() {
        return staffs;
    }

    /**
     * @param staffs The staffs
     */
    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

}
