package com.haotian.consumer.Convenient;

public class QuestionAndAnswer {
    private long answerID;

    public long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(long answerID) {
        this.answerID = answerID;
    }

    private long questionID;

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    private String question;//问题内容
    private String studentAnswer;//学生答案
    private String correct;//正确答案
    private String score;//题目分值

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
