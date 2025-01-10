package org.example.quizapiproject.entity;

import java.util.List;

public class Quiz {
    private int id;
    private String question;
    private List<String> answers;
    private String rightAnswer;

    public Quiz() {
    }

    public Quiz(int id, String question, List<String> answers, String rightAnswer) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}
