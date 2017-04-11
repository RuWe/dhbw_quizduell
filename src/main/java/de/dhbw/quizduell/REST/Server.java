package de.dhbw.quizduell.REST;

import org.restlet.Component;
import org.restlet.data.Protocol;

import java.io.IOException;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class Server {

    public static void main(String[] args) throws IOException, Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8085);
        component.getDefaultHost().attach("/rest", new RestApp());
        component.start();
    }
}
