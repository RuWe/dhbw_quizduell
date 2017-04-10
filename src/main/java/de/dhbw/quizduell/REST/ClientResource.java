package de.dhbw.quizduell.REST;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.io.IOException;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class ClientResource extends ServerResource{
    @Get
    public Representation helloWorld() {
        ClientGame clientMessage = new ClientGame("hallo JSON Welt");
        return new JacksonRepresentation<ClientGame>(clientMessage);
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
