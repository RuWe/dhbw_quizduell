package de.dhbw.quizduell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Server {

    public Server() {}

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cassandra");
        entityManagerFactory.close();
    }


}
