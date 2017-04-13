package de.dhbw.quizduell;

import javax.persistence.EntityManager;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Game {
    EntityManager entityManager = new EntityManagerClass().getEntityManager();


    public Game() {
    }

    public void startGame(Player playerEins, Player playerZwei) {
        Duell duell = new Duell();
        duell.setPlayer1(playerEins);
        duell.setPlayer2(playerZwei);

        entityManager.getTransaction().begin();
        entityManager.persist(duell);
        entityManager.getTransaction().commit();
    }


}
