package com.haotian.api.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Question")
public class Question implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testQuestionID;
    @Column
    private String testQuestionContent;
    @Column private String testQuestionTrueAns;
    @Column private String testQuestionScore;
    @Column private long testPaperID;


    public long getTestQuestionID() {
        return testQuestionID;
    }

    public void setTestQuestionID(long testQuestionID) {
        this.testQuestionID = testQuestionID;
    }

    public String getTestQuestionContent() {
        return testQuestionContent;
    }

    public void setTestQuestionContent(String testQuestionContent) {
        this.testQuestionContent = testQuestionContent;
    }

    public String getTestQuestionTrueAns() {
        return testQuestionTrueAns;
    }

    public void setTestQuestionTrueAns(String testQuestionTrueAns) {
        this.testQuestionTrueAns = testQuestionTrueAns;
    }

    public String getTestQuestionScore() {
        return testQuestionScore;
    }

    public void setTestQuestionScore(String testQuestionScore) {
        this.testQuestionScore = testQuestionScore;
    }

    public long getTestPaperID() {
        return testPaperID;
    }

    public void setTestPaperID(long testPaperID) {
        this.testPaperID = testPaperID;
    }



}
