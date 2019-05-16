package com.example.lab2.model;

public class Question {
    private String questionText;
    private String[] answers;
    private int indexOfProperAnswer;

    public Question(String questionText, int indexOfProperAnswer, String... answers) {
        this.questionText = questionText;
        this.answers = answers;
        this.indexOfProperAnswer = indexOfProperAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getIndexOfProperAnswer() {
        return indexOfProperAnswer;
    }

    public String getProperAnswer() {
        return answers[indexOfProperAnswer];
    }
}
