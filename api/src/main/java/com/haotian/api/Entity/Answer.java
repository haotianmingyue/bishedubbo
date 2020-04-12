package com.haotian.api.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Answer")
public class Answer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerID;
    @Column
    private long testEamineeAnswerID;
    @Column private long testID;

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }

    @Column private long testQuestionID;
    @Column private String testQuestionEamineeAns;
    @Column private String testQuestionEScore;

    public long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(long answerID) {
        this.answerID = answerID;
    }

    public long getTestEamineeAnswerID() {
        return testEamineeAnswerID;
    }

    public void setTestEamineeAnswerID(long testEamineeAnswerID) {
        this.testEamineeAnswerID = testEamineeAnswerID;
    }

    public long getTestQuestionID() {
        return testQuestionID;
    }

    public void setTestQuestionID(long testQuestionID) {
        this.testQuestionID = testQuestionID;
    }

    public String getTestQuestionEamineeAns() {
        return testQuestionEamineeAns;
    }

    public void setTestQuestionEamineeAns(String testQuestionEamineeAns) {
        this.testQuestionEamineeAns = testQuestionEamineeAns;
    }

    public String getTestQuestionEScore() {
        return testQuestionEScore;
    }

    public void setTestQuestionEScore(String testQuestionEScore) {
        this.testQuestionEScore = testQuestionEScore;
    }
}
