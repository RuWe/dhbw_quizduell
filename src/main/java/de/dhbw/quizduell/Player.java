package de.dhbw.quizduell;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Player {

    private long id;

    private String playerName;

    private int score;

    private Player() {}

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
