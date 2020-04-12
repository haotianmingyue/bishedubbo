package com.haotian.api.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Paper")
public class Paper implements Serializable {
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testPaperID;
    @Column
    private String testPaperTime;
    @Column private String testPaperTotalTime;
    @Column private long testQuestionSetterID;
    @Column private String testIsApproved;
//    @Column private String isConsult;

//    public String getIsConsult() {
//        return isConsult;
//    }
//
//    public void setIsConsult(String isConsult) {
//        this.isConsult = isConsult;
//    }

    public String getTestIsApproved() {
        return testIsApproved;
    }

    public void setTestIsApproved(String testIsApproved) {
        this.testIsApproved = testIsApproved;
    }

    public long getTestPaperID() {
        return testPaperID;
    }

    public void setTestPaperID(long testPaperID) {
        this.testPaperID = testPaperID;
    }

    public String getTestPaperTime() {
        return testPaperTime;
    }

    public void setTestPaperTime(String testPaperTime) {
        this.testPaperTime = testPaperTime;
    }

    public String getTestPaperTotalTime() {
        return testPaperTotalTime;
    }

    public void setTestPaperTotalTime(String testPaperTotalTime) {
        this.testPaperTotalTime = testPaperTotalTime;
    }

    public long getTestQuestionSetterID() {
        return testQuestionSetterID;
    }

    public void setTestQuestionSetterID(long testQuestionSetterID) {
        this.testQuestionSetterID = testQuestionSetterID;
    }
}
