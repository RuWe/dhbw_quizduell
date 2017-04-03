package de.dhbw.quizduell;

import java.util.List;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Question {

    private long id;

    private String question;

    private List<Answer> answers;

    private Answer correctAnswer;

    private Question() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
