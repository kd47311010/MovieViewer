package com.namhyun.movieviewerassist.models.kobis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Staff {

    @SerializedName("peopleNm")
    @Expose
    private String peopleNm;
    @SerializedName("peopleNmEn")
    @Expose
    private String peopleNmEn;
    @SerializedName("staffRoleNm")
    @Expose
    private String staffRoleNm;

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
     * @return The staffRoleNm
     */
    public String getStaffRoleNm() {
        return staffRoleNm;
    }

    /**
     * @param staffRoleNm The staffRoleNm
     */
    public void setStaffRoleNm(String staffRoleNm) {
        this.staffRoleNm = staffRoleNm;
    }

}
