package de.dhbw.quizduell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by kfrank on 13.04.2017.
 */
public class EntityManagerClass {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emf");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public EntityManagerClass() {}

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void close() {
        entityManagerFactory.close();
    }

}
