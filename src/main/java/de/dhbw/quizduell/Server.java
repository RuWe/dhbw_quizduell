package de.dhbw.quizduell;

import javax.persistence.*;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Server {

    public Server() {}

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emf");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Game game = new Game();

        Player player1 = new Player();
        Player player2 = new Player();

        player1.setPlayerName("Peter");
        player1.setScore(2);
        player2.setPlayerName("Klaus");
        player2.setScore(5);

        Duell duell = new Duell();
        duell.setPlayer1(player1);
        duell.setPlayer2(player2);

        entityManager.getTransaction().begin();
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.persist(duell);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }


}
