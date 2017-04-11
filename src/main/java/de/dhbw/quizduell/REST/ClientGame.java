package de.dhbw.quizduell.REST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
@JsonIgnoreProperties("password")
public class ClientGame {

    public String message;

    public String password = "superSecret";

    public ClientGame() {

    }

    public ClientGame(String string) {
        this.message = string;
    }
}
