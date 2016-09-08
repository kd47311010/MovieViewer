package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Audit {

    @SerializedName("auditNo")
    @Expose
    private String auditNo;
    @SerializedName("watchGradeNm")
    @Expose
    private String watchGradeNm;

    /**
     * @return The auditNo
     */
    public String getAuditNo() {
        return auditNo;
    }

    /**
     * @param auditNo The auditNo
     */
    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    /**
     * @return The watchGradeNm
     */
    public String getWatchGradeNm() {
        return watchGradeNm;
    }

    /**
     * @param watchGradeNm The watchGradeNm
     */
    public void setWatchGradeNm(String watchGradeNm) {
        this.watchGradeNm = watchGradeNm;
    }

}
