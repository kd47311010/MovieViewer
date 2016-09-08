package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("companyCd")
    @Expose
    private String companyCd;
    @SerializedName("companyNm")
    @Expose
    private String companyNm;
    @SerializedName("companyNmEn")
    @Expose
    private String companyNmEn;
    @SerializedName("companyPartNm")
    @Expose
    private String companyPartNm;

    /**
     * @return The companyCd
     */
    public String getCompanyCd() {
        return companyCd;
    }

    /**
     * @param companyCd The companyCd
     */
    public void setCompanyCd(String companyCd) {
        this.companyCd = companyCd;
    }

    /**
     * @return The companyNm
     */
    public String getCompanyNm() {
        return companyNm;
    }

    /**
     * @param companyNm The companyNm
     */
    public void setCompanyNm(String companyNm) {
        this.companyNm = companyNm;
    }

    /**
     * @return The companyNmEn
     */
    public String getCompanyNmEn() {
        return companyNmEn;
    }

    /**
     * @param companyNmEn The companyNmEn
     */
    public void setCompanyNmEn(String companyNmEn) {
        this.companyNmEn = companyNmEn;
    }

    /**
     * @return The companyPartNm
     */
    public String getCompanyPartNm() {
        return companyPartNm;
    }

    /**
     * @param companyPartNm The companyPartNm
     */
    public void setCompanyPartNm(String companyPartNm) {
        this.companyPartNm = companyPartNm;
    }

}
