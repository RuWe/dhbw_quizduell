package de.dhbw.quizduell.REST;

import org.restlet.Restlet;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class RestClient extends Restlet {

    public static void main(String[] args) {
        ClientGame world = new ClientGame("Der Client ist toll");

        Representation representation = new JacksonRepresentation<ClientGame>(world);
        new ClientResource("http://127.0.0.1:8085/rest/hello/10").put(representation);
    }
}
