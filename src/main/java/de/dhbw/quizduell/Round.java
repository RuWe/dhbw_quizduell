package de.dhbw.quizduell;

import java.util.List;
import java.util.Map;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Round {

    private long id;

    private List<Question> questions;

    private Map<Question, Answer> answersPlayer1;

    private Map<Question, Answer> answersPlayer2;

    private  Round() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Map<Question, Answer> getAnswersPlayer1() {
        return answersPlayer1;
    }

    public void setAnswersPlayer1(Map<Question, Answer> answersPlayer1) {
        this.answersPlayer1 = answersPlayer1;
    }

    public Map<Question, Answer> getAnswersPlayer2() {
        return answersPlayer2;
    }

    public void setAnswersPlayer2(Map<Question, Answer> answersPlayer2) {
        this.answersPlayer2 = answersPlayer2;
    }
}
