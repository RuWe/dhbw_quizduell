package de.dhbw.quizduell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Question> questions;

    @OneToMany(mappedBy = "round", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Question_Answer_Set> answer;


    @JsonIgnore
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

    public List<Question_Answer_Set> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Question_Answer_Set> answerPlayer1) {
        this.answer = answerPlayer1;
    }

    public Duell getDuell() {
        return duell;
    }

    public void setDuell(Duell duell) {
        this.duell = duell;
    }
}
