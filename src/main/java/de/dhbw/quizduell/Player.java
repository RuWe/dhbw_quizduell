package de.dhbw.quizduell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
@Entity
public class Player {

    @Id
    private long id;

    private String playerName;

    private int score;

    public Player() {}

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) { this.score = score; }
}
