package de.dhbw.quizduell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Ruth Weber on 06.04.2017.
 */
@Entity
public class Question_Answer_Set {

    @Id
    private long id;

    @OneToOne
    private Answer answer;

    @OneToOne
    private Question question;

    @OneToOne
    private Player player;

    @ManyToOne
    private Round round;

    public Question_Answer_Set() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
