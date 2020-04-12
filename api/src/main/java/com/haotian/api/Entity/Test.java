package com.haotian.api.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Test")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long testID;
    @Column
    private long testPaperID;
    @Column private long testEamineeAnswerID;
    @Column private String testTotalScore;
    @Column private long testRespondentID;
    @Column private String testTime;
    @Column private String isConsult;
    @Column private long testQuestionSetterID;

    public long getTestQuestionSetterID() {
        return testQuestionSetterID;
    }

    public void setTestQuestionSetterID(long testQuestionSetterID) {
        this.testQuestionSetterID = testQuestionSetterID;
    }

    public String getIsConsult() {
        return isConsult;
    }

    public void setIsConsult(String isConsult) {
        this.isConsult = isConsult;
    }

    public Long getTestID() {
        return testID;
    }

    public void setTestID(Long testID) {
        this.testID = testID;
    }

    public long getTestPaperID() {
        return testPaperID;
    }

    public void setTestPaperID(long testPaperID) {
        this.testPaperID = testPaperID;
    }

    public long getTestEamineeAnswerID() {
        return testEamineeAnswerID;
    }

    public void setTestEamineeAnswerID(long testEamineeAnswerID) {
        this.testEamineeAnswerID = testEamineeAnswerID;
    }

    public String getTestTotalScore() {
        return testTotalScore;
    }

    public void setTestTotalScore(String testTotalScore) {
        this.testTotalScore = testTotalScore;
    }

    public long getTestRespondentID() {
        return testRespondentID;
    }

    public void setTestRespondentID(long testRespondentID) {
        this.testRespondentID = testRespondentID;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }
}
