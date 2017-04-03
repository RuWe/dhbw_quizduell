package de.dhbw.quizduell;

import java.util.List;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Duell {

    private long id;

    private Player player1;

    private Player player2;

    private List<Round> rounds;

    private Duell() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
