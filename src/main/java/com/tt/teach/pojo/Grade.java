package com.tt.teach.pojo;

import java.io.Serializable;

/**
 *@作者：lsq
 *@时间：2018/12/19 15:20
 *@描述：
 */

public class Grade implements Serializable{
    private Integer gradeID;
    private String gradeName;

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
