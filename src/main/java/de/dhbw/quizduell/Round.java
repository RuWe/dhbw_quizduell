package de.dhbw.quizduell;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
@Entity
public class Round {

    @Id
    private long id;

    @ManyToMany
    private List<Question> questions;

    @OneToMany(mappedBy = "round")
    private List<Question_Answer_Set> answerPlayer1;

    @OneToMany(mappedBy = "round")
    private List<Question_Answer_Set> answerPlayer2;

    @ManyToOne
    private Duell duell;

    public Round() {}

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

    public List<Question_Answer_Set> getAnswerPlayer1() {
        return answerPlayer1;
    }

    public void setAnswerPlayer1(List<Question_Answer_Set> answerPlayer1) {
        this.answerPlayer1 = answerPlayer1;
    }

    public List<Question_Answer_Set> getAnswerPlayer2() {
        return answerPlayer2;
    }

    public void setAnswerPlayer2(List<Question_Answer_Set> answerPlayer2) {
        this.answerPlayer2 = answerPlayer2;
    }

    public Duell getDuell() {
        return duell;
    }

    public void setDuell(Duell duell) {
        this.duell = duell;
    }
}
