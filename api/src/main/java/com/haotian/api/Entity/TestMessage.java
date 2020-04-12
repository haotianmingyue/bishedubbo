package com.haotian.api.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TestMessage")
public class TestMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testMessageID;
    @Column
    private long testGetterID;
    @Column
    private String testMessageContent;
    @Column
    private long messageReviewerID;
    @Column
    private String messageIsConsult;
    @Column
    private long testPaperID;

    public long getTestMessageID() {
        return testMessageID;
    }

    public void setTestMessageID(long testMessageID) {
        this.testMessageID = testMessageID;
    }

    public long getTestGetterID() {
        return testGetterID;
    }

    public void setTestGetterID(long testGetterID) {
        this.testGetterID = testGetterID;
    }

    public String getTestMessageContent() {
        return testMessageContent;
    }

    public void setTestMessageContent(String testMessageContent) {
        this.testMessageContent = testMessageContent;
    }

    public long getMessageReviewerID() {
        return messageReviewerID;
    }

    public void setMessageReviewerID(long messageReviewerID) {
        this.messageReviewerID = messageReviewerID;
    }

    public String getMessageIsConsult() {
        return messageIsConsult;
    }

    public void setMessageIsConsult(String messageIsConsult) {
        this.messageIsConsult = messageIsConsult;
    }

    public long getTestPaperID() {
        return testPaperID;
    }

    public void setTestPaperID(long testPaperID) {
        this.testPaperID = testPaperID;
    }
}
