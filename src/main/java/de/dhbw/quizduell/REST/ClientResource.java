package de.dhbw.quizduell.REST;

import de.dhbw.quizduell.Duell;
import de.dhbw.quizduell.EntityManagerClass;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class ClientResource extends ServerResource{
    @Get
    public Representation helloWorld() {
        EntityManager entityManager = new EntityManagerClass().getEntityManager();

        long playerId = Long.parseLong((String) getRequestAttributes().get("playerId"));

        List<Duell> duellList = entityManager.createQuery("FROM Duell WHERE player1.id = :playerId").setParameter("playerId", playerId).getResultList();
        duellList.addAll(entityManager.createQuery("FROM Duell WHERE player2.id = :playerId").setParameter("playerId", playerId).getResultList());

        System.out.println(duellList);

        entityManager.close();
        return new JacksonRepresentation<List<Duell>>(duellList);
    }

    @Put
    public void update(Representation rep) throws IOException {
        if(getRequestAttributes().containsKey("id")) {
            System.out.println("id is " + getRequestAttributes().get("id"));
        }
        JacksonRepresentation<ClientGame> wr = new JacksonRepresentation<ClientGame>(rep, ClientGame.class);
        ClientGame clientGame = wr.getObject();
        System.out.println("Client has message "+ clientGame.message);

    }

}
