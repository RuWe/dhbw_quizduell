package de.dhbw.quizduell.REST;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class ClientGame {

    public String message;

    public String password = "superSecret";

    public ClientGame() {

    }

    public ClientGame(String string) {
        this.message = string;
    }
}
