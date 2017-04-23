package de.dhbw.quizduell.REST;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.service.CorsService;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Ruth Weber on 10.04.2017.
 */
public class RestServer {

    public static void main(String[] args) throws IOException, Exception {
        CorsService corsService = new CorsService();
        corsService.setAllowedOrigins(new HashSet(Collections.singletonList("*")));
        corsService.setAllowedCredentials(true);

        Component component = new Component();
        component.getServices().add(corsService);
        component.getServers().add(Protocol.HTTP, 8085);
        component.getDefaultHost().attach("/rest", new RestApp());
        component.start();
    }
}
